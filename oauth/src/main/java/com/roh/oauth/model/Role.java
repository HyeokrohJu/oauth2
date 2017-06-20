/**
 * <pre>
 * 1. 프로젝트명 : oauth
 * 2. 패키지명(또는 디렉토리 경로) : com.roh.oauth.model
 * 3. 파일명 : Role.java
 * 4. 작성일 : 2017. 6. 19. 오후 10:19:10
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.roh.oauth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 1. 패키지명 : com.roh.oauth.model
 * 2. 타입명 : Role.java
 * 3. 작성일 : 2017. 6. 19. 오후 10:19:10
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */

@Entity
public class Role {
	@Id
	private Long id;
	
	@NotNull
	private String code;
	
	@NotNull
	private String label;
	
	public Role(){}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
