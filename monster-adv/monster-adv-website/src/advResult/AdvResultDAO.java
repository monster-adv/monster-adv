package advResult;

import java.util.Collection;

import base.DAO;

public interface AdvResultDAO extends DAO{

	public boolean insert(AdvResult result);
	
	public boolean delete(AdvResult result);
	
	public Collection<AdvResult> search(String adv_num,String date);

	
}

