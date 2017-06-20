/**
 * <pre>
 * 1. 프로젝트명 : oauth
 * 2. 패키지명(또는 디렉토리 경로) : com.roh.oauth.validator
 * 3. 파일명 : UniqueUsername.java
 * 4. 작성일 : 2017. 6. 19. 오후 10:30:56
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.roh.oauth.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * <pre>
 * 1. 패키지명 : com.roh.oauth.validator
 * 2. 타입명 : UniqueUsername.java
 * 3. 작성일 : 2017. 6. 19. 오후 10:30:56
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueUsernameValidator.class })
public @interface UniqueUsername {
	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
