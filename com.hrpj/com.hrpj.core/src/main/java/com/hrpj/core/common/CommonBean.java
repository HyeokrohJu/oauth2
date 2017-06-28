/**
 * <pre>
 * 1. 프로젝트명 : restful
 * 2. 패키지명(또는 디렉토리 경로) : com.hrpj.core.common
 * 3. 파일명 : CommonBean.java
 * 4. 작성일 : 2017. 6. 27. 오후 6:17:51
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.hrpj.core.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <pre>
 * 1. 패키지명 : com.hrpj.core.common
 * 2. 타입명 : CommonBean.java
 * 3. 작성일 : 2017. 6. 28. 오후 11:04:31
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */
@Getter
@Setter
@NoArgsConstructor
public class CommonBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String hrschema;
	private String hrtimezone;
	private long hrtime;
	private String hrtimefmt;
	private String ordercol = "";
	private String ordertype = "asc";
	
	/**
	 * Custom Field
	 */
	private String custom1;
	private String custom2;
	private String custom3;
	
}
