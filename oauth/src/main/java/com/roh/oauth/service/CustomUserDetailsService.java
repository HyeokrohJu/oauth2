/**
 * <pre>
 * 1. 프로젝트명 : oauth
 * 2. 패키지명(또는 디렉토리 경로) : com.roh.oauth.servie
 * 3. 파일명 : CustomUserDetailsService.java
 * 4. 작성일 : 2017. 6. 19. 오후 10:08:48
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.roh.oauth.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roh.oauth.model.Role;
import com.roh.oauth.model.UserInfo;
import com.roh.oauth.repository.UserInfoRepository;

/**
 * <pre>
 * 1. 패키지명 : com.roh.oauth.servie
 * 2. 타입명 : CustomUserDetailsService.java
 * 3. 작성일 : 2017. 6. 19. 오후 10:08:48
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserInfoRepository userInfoRepository;

	private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

	@Autowired
	public CustomUserDetailsService(UserInfoRepository userInfoRepository) {
		this.userInfoRepository = userInfoRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoRepository.findByUsername(username);

		if (userInfo == null) {
			throw new UsernameNotFoundException("User " + username + " not found.");
		}

		if (userInfo.getRoles() == null || userInfo.getRoles().isEmpty()) {
			throw new UsernameNotFoundException("User not authorized.");
		}

		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (Role role : userInfo.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
		}

		detailsChecker.check(userInfo);

		return userInfo;
	}

}
