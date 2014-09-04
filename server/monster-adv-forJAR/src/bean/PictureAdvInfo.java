package bean;

public class PictureAdvInfo extends PictureAdv{

	private int supremumTime;
	public PictureAdvInfo(String location) {
		super(location);
		// TODO Auto-generated constructor stub
	}
	
	public PictureAdvInfo(String name,String location, int supremumTime) {
		super(name,location);
		this.supremumTime = supremumTime;
	}

	public int getSupremumTime() {
		return supremumTime;
	}
	public void setSupremumTime(int supremumTime) {
		this.supremumTime = supremumTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + supremumTime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PictureAdvInfo other = (PictureAdvInfo) obj;
		if (supremumTime != other.supremumTime)
			return false;
		return true;
	}
	
	
}
