package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MobileCustomerCenter {

	@Id
	private Long mobileNo;
	

	private String cname;
	private String callerTune;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCallerTune() {
		return callerTune;
	}

	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}

	@Override
	public String toString() {
		return "MobileCustomerCenter [mobileNo=" + mobileNo + ", cname=" + cname + ", callerTune=" + callerTune + "]";
	}
}