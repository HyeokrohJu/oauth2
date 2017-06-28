package com.hrpj.core.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import com.hrpj.core.common.CommonThreadLocalBean;

/**
 * <pre>
 * 1. 패키지명 : com.roh.restful.filter
 * 2. 타입명 : OAuth2Filter.java
 * 3. 작성일 : 2017. 6. 27. 오후 5:09:27
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   : OAuth2 Filter
 * </pre>
 */
@Component
public class OAuth2Filter implements Filter {

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String jwtToken = request.getHeader("Authorization");
		jwtToken = jwtToken.replaceAll("Bearer ", "");
		final OAuth2AccessToken accessToken = tokenStore.readAccessToken(jwtToken);
		Map<String, Object> jwtInfo = accessToken.getAdditionalInformation();

		jwtInfo.put("User-Agent", request.getHeader("User-Agent"));
		jwtInfo.put("remotehost", request.getRemoteHost());

		CommonThreadLocalBean.setJwtInfo(jwtInfo);

		Map<String, Object> userInfo = CommonThreadLocalBean.getUserInfo();

		if (userInfo != null) {
			logger.debug("### CURRENT JWT INFO 0.: " + accessToken);
			logger.debug("### CURRENT JWT INFO 1.: " + userInfo.get("usernm"));
			logger.debug("### CURRENT JWT INFO 2.: " + userInfo.get("userid"));
			logger.debug("### CURRENT JWT INFO 3.: " + userInfo.get("loginid"));

		} else {
            logger.debug( "### JWT IS EMPTY ###" );
            logger.debug( "### requestUrI : " + request.getRequestURI( ) );
            
            CommonThreadLocalBean.removeJwtInfo();
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
