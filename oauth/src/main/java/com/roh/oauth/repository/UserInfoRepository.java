/**
 * <pre>
 * 1. 프로젝트명 : oauth
 * 2. 패키지명(또는 디렉토리 경로) : com.roh.oauth.repository
 * 3. 파일명 : UserinfoRepository.java
 * 4. 작성일 : 2017. 6. 19. 오후 9:03:47
 * 5. 작성자 : Ju Hyeokroh
 * 6. 설명   :
 * </pre>
 */

package com.roh.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.roh.oauth.model.UserInfo;

/**
 * <pre>
 * 1. 패키지명 : com.roh.oauth.repository
 * 2. 타입명 : UserinfoRepository.java
 * 3. 작성일 : 2017. 6. 19. 오후 9:03:47
 * 4. 작성자 : Ju Hyeokroh
 * 5. 설명   :
 * </pre>
 */

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	@Query("SELECT a FROM userinfo a WHERE a.username = :username")
	UserInfo findByUsername(@Param("username") String username);
}
