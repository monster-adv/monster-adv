package bean;
import java.util.Calendar;

public class AnalysisResult 
{
	private Calendar startTime;
	private Calendar endTime;
	private int numOfMr;
	private int numOfMs;
	
	public AnalysisResult()
	{
		this.numOfMr = 0;
		this.numOfMs = 0;
	}
	
	AnalysisResult(Calendar startTime, Calendar endTime)
	{
		this.setStartTime(startTime);
		this.setEndTime(endTime);
		this.numOfMr = 0;
		this.numOfMs = 0;
	}

	public int getNumOfMr() {
		return numOfMr;
	}

	public void setNumOfMr(int numOfMr) {
		this.numOfMr = numOfMr;
	}

	public int getNumOfMs() {
		return numOfMs;
	}

	public void setNumOfMs(int numOfMs) {
		this.numOfMs = numOfMs;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + numOfMr;
		result = prime * result + numOfMs;
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
		AnalysisResult other = (AnalysisResult) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (numOfMr != other.numOfMr)
			return false;
		if (numOfMs != other.numOfMs)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
	
}
