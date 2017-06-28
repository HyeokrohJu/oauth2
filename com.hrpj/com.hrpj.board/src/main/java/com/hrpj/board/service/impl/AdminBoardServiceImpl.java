/**
 * <pre>
 * 1. 프로젝트명 : restful
 * 2. 패키지명(또는 디렉토리 경로) : com.hrpj.board.service.impl
 * 3. 파일명 : AdminBoardServiceImpl.java
 * 4. 작성일 : 2017. 6. 27. 오후 6:47:13
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.hrpj.board.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrpj.board.dao.RohbBrdDao;
import com.hrpj.board.service.AdminBoardService;
import com.hrpj.core.exception.BusinessLogicException;

/**
 * <pre>
 * 1. 패키지명 : com.hrpj.board.service.impl
 * 2. 타입명 : AdminBoardServiceImpl.java
 * 3. 작성일 : 2017. 6. 28. 오후 11:25:34
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */
@Service("adminBoardService")
public class AdminBoardServiceImpl implements AdminBoardService {

	@Autowired
	private RohbBrdDao rohbBrdDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.roh.restful.board.service.AdminBoardService#getBrdTree(java.util.Map)
	 */
	@Override
	public Map<String, Object> getBrdTree(Map<String, Object> paramMap) throws BusinessLogicException {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("status", "000");
		try {
			retMap.put("brdTree", rohbBrdDao.getBrdTree(paramMap));
		} catch (Exception e) {
			retMap.put("status", "100");
			e.printStackTrace();
			throw new BusinessLogicException("");
		}
		return retMap;
	}

}
