/**
 * <pre>
 * 1. 프로젝트명 : restful
 * 2. 패키지명(또는 디렉토리 경로) : com.hrpj.board.service
 * 3. 파일명 : AdminBoardService.java
 * 4. 작성일 : 2017. 6. 20. 오후 5:44:14
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.hrpj.board.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.hrpj.core.exception.BusinessLogicException;

/**
 * <pre>
 * 1. 패키지명 : com.hrpj.board.service
 * 2. 타입명 : AdminBoardService.java
 * 3. 작성일 : 2017. 6. 28. 오후 11:25:06
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */
@Service("adminBoardService")
public interface AdminBoardService {

	/**
	 * <pre>
	 * 1. 함수명 : getBrdTree
	 * 2. 작성일 : 2017. 6. 27. 오후 6:51:17
	 * 3. 작성자 : Ju Hyeokroh
	 * 4. 설명   : 게시판 계층형 조회
	 * </pre>
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceInterfaceException
	 */
	public Map<String, Object> getBrdTree(Map<String, Object> paramMap) throws BusinessLogicException;

}
