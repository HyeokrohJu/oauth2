package com.hrpj.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrpj.board.service.AdminBoardService;
import com.hrpj.core.exception.BusinessLogicException;

/**
 * <pre>
 * 1. 패키지명 : com.hrpj.board.controller
 * 2. 타입명 : AdminBoardController.java
 * 3. 작성일 : 2017. 6. 28. 오후 11:26:10
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */
@RestController
@PreAuthorize("#oauth2.hasScope('rest:admin') or #oauth2.hasScope('admin:board')")
@RequestMapping("/admin/board")
public class AdminBoardController {
	
	@Autowired
	AdminBoardService adminboardService;
	
	@RequestMapping("/brdtree")
	public Map<String, Object> members(Map<String, Object> paramMap){
		
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
			Map<String, Object> brdTree = adminboardService.getBrdTree(paramMap);
			responseMap.put("brdTree", brdTree);
		} catch (BusinessLogicException e) {
			e.printStackTrace();
		}
		
		return responseMap;
	}
}