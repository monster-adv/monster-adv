package bean;

public class FilmAdvInfo extends FilmAdv{
	private PeopleKind kind;
	private int supremumPerson;
	
	public FilmAdvInfo(String loaction, int playtime, PeopleKind kind,
			int supremumPerson) {
		super(loaction, playtime);
		this.kind = kind;
		this.supremumPerson = supremumPerson;
	}
	
	public PeopleKind getKind()
	{
		return kind;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + supremumPerson;
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
		FilmAdvInfo other = (FilmAdvInfo) obj;
		if (kind != other.kind)
			return false;
		if (supremumPerson != other.supremumPerson)
			return false;
		return true;
	}
	
	
}
