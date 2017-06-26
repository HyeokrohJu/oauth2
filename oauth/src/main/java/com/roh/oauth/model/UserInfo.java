/**
 * <pre>
 * 1. 프로젝트명 : oauth
 * 2. 패키지명(또는 디렉토리 경로) : com.roh.oauth.model
 * 3. 파일명 : UserInfo.java
 * 4. 작성일 : 2017. 6. 19. 오후 8:48:25
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.roh.oauth.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.roh.oauth.validator.UniqueUsername;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <pre>
 * 1. 패키지명 : com.roh.oauth.model
 * 2. 타입명 : UserInfo.java
 * 3. 작성일 : 2017. 6. 19. 오후 8:48:25
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */

@Entity(name = "userinfo")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@UniqueUsername(message = "Username already exists")
	@Size(min = 8, max = 255, message = "Username have to be grater than 8 characters")
	@Column(unique = true)
	private String username;

	@NotNull
	@Size(min = 8, max = 255, message = "Password have to be grater than 8 characters")
	private String password;

	@NotNull
	private boolean enabled = true;

	@NotNull
	private boolean credentialsexpired = false;

	@NotNull
	private boolean expired = false;

	@NotNull
	private boolean locked = false;

	@Null
	private Timestamp createdat;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "userinforole", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id"))
	private Set<Role> roles;

	public UserInfo(UserInfo userinfo) {
		this.id = userinfo.getId();
		this.username = userinfo.getUsername();
		this.password = userinfo.getPassword();
		this.enabled = userinfo.isEnabled();
		this.credentialsexpired = userinfo.isCredentialsexpired();
		this.locked = userinfo.isExpired();
		this.roles = userinfo.getRoles();
		this.createdat = userinfo.getCreatedat();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.core.userdetails.UserDetails#getAuthorities(
	 * )
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		for (Role role : getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		return grantedAuthorities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return !expired;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetails#
	 * isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialsexpired;
	}

}
