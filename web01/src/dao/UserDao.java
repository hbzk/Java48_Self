package dao;

import vo.UserVo;

public interface UserDao {
	UserVo getUser(String email, String password)/* throws Exception*/; 	// > 에러 객체를 사용
}
