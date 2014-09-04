package advertisement;

public class Advertisement {
	private String name;
	private String advNum;
	private String masterId;
	private String SignageId;
	private String peopleKind;
	private String advKind;
	private int time;
	private int sum;
	private int men_count;
	private int women_count;	
	private String locate;
	
	
	
	@Override
	public String toString() {
		return "Advertisement [name=" + name + ", advNum=" + advNum
				+ ", masterId=" + masterId + ", SignageId=" + SignageId
				+ ", peopleKind=" + peopleKind + ", advKind=" + advKind
				+ ", time=" + time + ", sum=" + sum + ", men_count="
				+ men_count + ", women_count=" + women_count + ", locate="
				+ locate + "]";
	}
	public Advertisement(String name, String advNum, String masterId,
			String signageId, String peopleKind, String advKind, int time,
			int sum, int men_count, int women_count, String locate) {
		super();
		this.name = name;
		this.advNum = advNum;
		this.masterId = masterId;
		SignageId = signageId;
		this.peopleKind = peopleKind;
		this.advKind = advKind;
		this.time = time;
		this.sum = sum;
		this.men_count = men_count;
		this.women_count = women_count;
		this.locate = locate;
	}
	public Advertisement(String name, String advNum, String masterId,
			String signageId, String peopleKind, String advKind, int time,
			int sum, String locate) {
		super();
		this.name = name;
		this.advNum = advNum;
		this.masterId = masterId;
		SignageId = signageId;
		this.peopleKind = peopleKind;
		this.advKind = advKind;
		this.time = time;
		this.sum = sum;
		this.locate = locate;
	}
	public Advertisement()
	{
		
	}
	public Advertisement(String name)
	{
		this.name=name;
	}
	
	
	public Advertisement(String name, String advNum, String masterId,
			String signageId, String peopleKind, String advKind, int time,
			int sum) {
		this.name = name;
		this.advNum = advNum;
		this.masterId = masterId;
		SignageId = signageId;
		this.peopleKind = peopleKind;
		this.advKind = advKind;
		this.time = time;
		this.sum = sum;
	}
	public String getAdvNum() {
		return advNum;
	}
	public void setAdvNum(String advNum) {
		this.advNum = advNum;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getSignageId() {
		return SignageId;
	}
	public void setSignageId(String signageId) {
		SignageId = signageId;
	}
	public String getPeopleKind() {
		return peopleKind;
	}
	public void setPeopleKind(String peopleKind) {
		this.peopleKind = peopleKind;
	}
	public String getAdvKind() {
		return advKind;
	}
	public void setAdvKind(String advKind) {
		this.advKind = advKind;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
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
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advertisement other = (Advertisement) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public int getWomen_count() {
		return women_count;
	}
	public void setWomen_count(int women_count) {
		this.women_count = women_count;
	}
	public int getMen_count() {
		return men_count;
	}
	public void setMen_count(int men_count) {
		this.men_count = men_count;
	}
	
	
}
