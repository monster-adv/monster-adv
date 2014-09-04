package bean;
import java.util.Calendar;



public class AdvResult {
	private String advName;
	private AdvKind advKind;
	private int advPlayedTime;
	private Calendar startTime;
	
	
	
	public String getAdvName() {
		return advName;
	}
	public void setAdvName(String advName) {
		this.advName = advName;
	}
	public AdvKind getAdvKind() {
		return advKind;
	}
	public void setAdvKind(AdvKind advKind) {
		this.advKind = advKind;
	}
	public int getAdvPlayedTime() {
		return advPlayedTime;
	}
	public void setAdvPlayedTime(int advPlayedTime) {
		this.advPlayedTime = advPlayedTime;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advKind == null) ? 0 : advKind.hashCode());
		result = prime * result + ((advName == null) ? 0 : advName.hashCode());
		result = prime * result + advPlayedTime;
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
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
		AdvResult other = (AdvResult) obj;
		if (advKind != other.advKind)
			return false;
		if (advName == null) {
			if (other.advName != null)
				return false;
		} else if (!advName.equals(other.advName))
			return false;
		if (advPlayedTime != other.advPlayedTime)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
	
}
