package user.action;
import user.*;

public class UserRegistAction {
	
	private UserDAO userDAO;
	
	/**
	 * UserDAO ����� SET �ϴ� �޼ҵ��Դϴ�.
	 * @param userDAO ȸ�� ������ �����ͺ��̽��� ����,����,����,�˻�,�ߺ�Ȯ���ϱ� ���� �������̽����� ����Դϴ�. 
	 */
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	/**
	 * ȸ�� ������ �ϱ� ���� �޼ҵ� �Դϴ�.
	 * @param user ȸ�� ������ ���� User class �Դϴ�. 
	 * @return ȸ�� ���� ���� ���� ���� 
	 */
	public boolean regist(User user){
		return userDAO.regist(user);
	}

}
