package kr.co.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.beans.UserBean;

public interface BuyerMapper {

	// 아이디 중복 체크에 사용된 sql
	@Select("select ID " + "from member " + "where ID=#{user_id}")
	String buyercheckUserExist(String user_id);

	// 회원가입 DB 등록
	@Insert("insert all into member (code, id, pw, name, mail, phone, address) "
			+ "values (('Cu' || TO_CHAR(user_seq.nextval)), #{user_id}, #{user_pw}, #{user_name}, #{user_email}, #{user_tel}, #{user_add1})"
			+ "into customer(code, favarite)"
			+ "values(('Cu' || TO_CHAR(user_seq.nextval)), null)"
			+ "SELECT * FROM DUAL")
	void buyeraddUserInfo(UserBean joinUserBean);

}
