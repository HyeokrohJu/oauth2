/**
 * <pre>
 * 1. 프로젝트명 : oauth
 * 2. 패키지명(또는 디렉토리 경로) : com.roh.oauth.configs
 * 3. 파일명 : OAuth2Configuration.java
 * 4. 작성일 : 2017. 6. 19. 오후 6:27:40
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.roh.oauth.configs;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.roh.oauth.model.UserInfo;
import com.roh.oauth.service.CustomUserDetailsService;

/**
 * <pre>
 * 1. 패키지명 : com.roh.oauth.configs
 * 2. 타입명 : OAuth2Configuration.java
 * 3. 작성일 : 2017. 6. 19. 오후 6:27:40
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */

@EnableAuthorizationServer
@Configuration
public class OAuth2Configuration {
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new CustomTokenEnhancer();
		converter.setSigningKey("123");
		
		DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
		DefaultUserAuthenticationConverter userTokenConverter = new DefaultUserAuthenticationConverter();
		userTokenConverter.setUserDetailsService(userDetailsService);
		accessTokenConverter.setUserTokenConverter(userTokenConverter);
		
		converter.setAccessTokenConverter(accessTokenConverter);
		
		return converter;
	}
	
	protected static class CustomTokenEnhancer extends JwtAccessTokenConverter {
		@Override
		public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
			UserInfo user = (UserInfo)authentication.getPrincipal();
			
			Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());
			info.put("email", user.getCreatedat());
			
			DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
			
			Set<GrantedAuthority> authoritiesSet = new HashSet<>(authentication.getAuthorities());
			
			String[] authorities = new String[authoritiesSet.size()];
			
			int i = 0;
			for(GrantedAuthority authority : authoritiesSet){
				authorities[i++] = authority.getAuthority();
			}
			
			info.put("authorities", authorities);
			customAccessToken.setAdditionalInformation(info);
			
			return super.enhance(customAccessToken, authentication);
		}
	}

	@Bean
	@Primary
	public JdbcClientDetailsService jdbcClientDetatilsService(DataSource dataSource) {
		return new JdbcClientDetailsService(dataSource);
	}
}
