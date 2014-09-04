package user;

import base.DAO;

/**
 * UserDAO �������̽��� ȸ�� ������ �����ͺ��̽��� ����,����,����,�˻�,�ߺ�Ȯ���ϱ� ���� �������̽��Դϴ�.
 */
public interface UserDAO extends DAO{
	
	/**
	 * ���̵�� ��й�ȣ�� �α����ϴ� �޼ҵ��Դϴ�.
	 * ���̵�� ��й�ȣ�� ��ġ�ϴ� LoginInfo ��ü�� �����մϴ�.
	 * @param userID ȸ�� ���̵� 
	 * @param password ȸ�� ��й�ȣ 
	 * @return ���̵�� ��й�ȣ�� ��ġ�ϴ� LoginInfo ��ü 
	 */
	public LoginInfo login(String userID, String password);

	/**
	 * ȸ�� �����ϴ� �޼ҵ��Դϴ�.
	 * ȸ�� ���� ���� ���� ���θ� �����մϴ�.
	 * @param user ȸ���� ����
	 * @return ȸ�����Կ� �����ϸ� true, ȸ�� ���Կ� �����ϸ� false
	 */
	public boolean regist(User user);
	
	/**
	 * ���̵� �ߺ� �˻��ϴ� �޼ҵ��Դϴ�.
	 * ���̵� �ߺ� �˻� ���θ� �����մϴ�.	
	 * @param userID ȸ�� ���̵�
	 * @return �ߺ� �Ǵ� ���̵� ���� �� ��� true, ���� ���� ���� ��� false
	 */
	public boolean isValidId(String userID);
	
	/**
	 * �̸��� �ߺ� �˻��ϴ� �޼ҵ��Դϴ�.
	 * �̸��� �ߺ� �˻� ���θ� �����մϴ�.	 
	 * @param email ȸ�� �̸���
	 * @return �ߺ� �Ǵ� �̸����� ���� �� ��� true, ���� ���� ���朗 ��� false
	 */
	public boolean isValidEmail(String email);
	
	/**
	 * ȸ�� ������ �����ϴ� �޼ҵ��Դϴ�.
	 * ȸ�� ���� ���� ���θ� �����մϴ�.
	 * @param user ȸ���� ����
	 * @return ȸ�� ���� ������ �����ϸ� true, �����ϸ� false
	 */
	public boolean modify(User user);
	
	/**
	 * ȸ�� Ż�� �ϴ� �޼ҵ��Դϴ�.
	 * ȸ�� Ż�� ���θ� �����մϴ�.
	 * @param user ȸ���� ����
	 * @return ȸ�� Ż�� �����ϸ� true, �����ϸ� false
	 */
	public boolean delete(User user);
}

