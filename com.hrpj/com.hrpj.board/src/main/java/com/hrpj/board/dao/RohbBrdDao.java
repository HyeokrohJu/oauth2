/**
 * <pre>
 * 1. 프로젝트명 : restful
 * 2. 패키지명(또는 디렉토리 경로) : com.hrpj.board.dao
 * 3. 파일명 : RohbBrdDao.java
 * 4. 작성일 : 2017. 6. 27. 오후 2:22:07
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.hrpj.board.dao;

import java.util.ArrayList;
import java.util.Map;

import org.h2.value.CaseInsensitiveMap;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * 1. 패키지명 : com.hrpj.board.dao
 * 2. 타입명 : RohbBrdDao.java
 * 3. 작성일 : 2017. 6. 28. 오후 11:25:52
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */
@Repository("rohbBrdDao")
public interface RohbBrdDao {
	public ArrayList<CaseInsensitiveMap<Object>> getBrdTree(Map<String, Object> paramMap) throws Exception;
}
