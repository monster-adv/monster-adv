package user.action;
import user.*;

public class UserRegistAction {
	
	private UserDAO userDAO;
	
	/**
	 * UserDAO 멤버를 SET 하는 메소드입니다.
	 * @param userDAO 회원 정보를 데이터베이스에 삽입,수정,삭제,검색,중복확인하기 위한 인터페이스입의 멤버입니다. 
	 */
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	/**
	 * 회원 가입을 하기 위한 메소드 입니다.
	 * @param user 회원 정보를 갖는 User class 입니다. 
	 * @return 회원 가입 성공 실패 여부 
	 */
	public boolean regist(User user){
		return userDAO.regist(user);
	}

}
