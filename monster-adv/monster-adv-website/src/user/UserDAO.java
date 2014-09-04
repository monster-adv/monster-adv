package user;

import base.DAO;

/**
 * UserDAO 인터페이스는 회원 정보를 데이터베이스에 삽입,수정,삭제,검색,중복확인하기 위한 인터페이스입니다.
 */
public interface UserDAO extends DAO{
	
	/**
	 * 아이디와 비밀번호로 로그인하는 메소드입니다.
	 * 아이디와 비밀번호가 일치하는 LoginInfo 객체를 리턴합니다.
	 * @param userID 회원 아이디 
	 * @param password 회원 비밀번호 
	 * @return 아이디와 비밀번호가 일치하는 LoginInfo 객체 
	 */
	public LoginInfo login(String userID, String password);

	/**
	 * 회원 가입하는 메소드입니다.
	 * 회원 가입 성공 실패 여부를 리턴합니다.
	 * @param user 회원의 정보
	 * @return 회원가입에 성공하면 true, 회원 가입에 실패하면 false
	 */
	public boolean regist(User user);
	
	/**
	 * 아이디 중복 검사하는 메소드입니다.
	 * 아이디 중복 검사 여부를 리턴합니다.	
	 * @param userID 회원 아이디
	 * @return 중북 되는 아이디가 존재 할 경우 true, 존재 하지 않을 경우 false
	 */
	public boolean isValidId(String userID);
	
	/**
	 * 이메일 중복 검사하는 메소드입니다.
	 * 이메일 중복 검사 여부를 리턴합니다.	 
	 * @param email 회원 이메일
	 * @return 중복 되는 이메일이 존재 할 경우 true, 존재 하지 안흥ㄹ 경우 false
	 */
	public boolean isValidEmail(String email);
	
	/**
	 * 회원 정보를 수정하는 메소드입니다.
	 * 회원 정보 수정 여부를 리턴합니다.
	 * @param user 회원의 정보
	 * @return 회원 정보 수정에 성공하면 true, 실패하면 false
	 */
	public boolean modify(User user);
	
	/**
	 * 회원 탈퇴 하는 메소드입니다.
	 * 회원 탈퇴 여부를 리턴합니다.
	 * @param user 회원의 정보
	 * @return 회원 탈퇴를 성공하면 true, 실패하면 false
	 */
	public boolean delete(User user);
}

