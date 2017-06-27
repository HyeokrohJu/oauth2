/**
 * <pre>
 * 1. 프로젝트명 : oauth
 * 2. 패키지명(또는 디렉토리 경로) : com.roh.oauth.dao
 * 3. 파일명 : UserInfoDao.java
 * 4. 작성일 : 2017. 6. 26. 오후 6:23:28
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.roh.oauth.dao;

import java.util.Map;
import java.util.Set;

import com.roh.oauth.vo.Role;
import com.roh.oauth.vo.UserInfo;


/**
 * <pre>
 * 1. 패키지명 : com.roh.oauth.dao
 * 2. 타입명 : UserInfoDao.java
 * 3. 작성일 : 2017. 6. 26. 오후 6:23:28
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */

public interface UserInfoDao {
	public UserInfo findByLoginId(Map<String, String> paramMap);
	
	public Set<Role> findRole(Map<String, String> paramMap);
}
