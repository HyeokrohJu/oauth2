/**
 * <pre>
 * 1. 프로젝트명 : oauth
 * 2. 패키지명(또는 디렉토리 경로) : com.roh.oauth.validator
 * 3. 파일명 : UniqueUsernameValidator.java
 * 4. 작성일 : 2017. 6. 19. 오후 10:31:48
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.roh.oauth.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.roh.oauth.repository.UserInfoRepository;

/**
 * <pre>
 * 1. 패키지명 : com.roh.oauth.validator
 * 2. 타입명 : UniqueUsernameValidator.java
 * 3. 작성일 : 2017. 6. 19. 오후 10:31:48
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserInfoRepository userInfoRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.validation.ConstraintValidator#initialize(java.lang.annotation.
	 * Annotation)
	 */
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
	 * javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		// If the repository is null then return null
		if (userInfoRepository == null) {
			return true;
		}
		// Check if the username is unique
		return userInfoRepository.findByUsername(username) == null;
	}

}
