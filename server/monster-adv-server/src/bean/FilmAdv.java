package bean;


public class FilmAdv{

	private String name;
	private String loaction;
	private int playtime;
	

	public FilmAdv(String loaction, int playtime) {
		super();
		this.loaction = loaction;
		this.playtime = playtime;
	}
	public String getLoaction() {
		return loaction;
	}
	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
	public int getPlaytime() {
		return playtime;
	}
	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((loaction == null) ? 0 : loaction.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + playtime;
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
		FilmAdv other = (FilmAdv) obj;
		if (loaction == null) {
			if (other.loaction != null)
				return false;
		} else if (!loaction.equals(other.loaction))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (playtime != other.playtime)
			return false;
		return true;
	}

	
}
