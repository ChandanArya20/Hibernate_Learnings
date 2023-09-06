package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class MobileCustomer {

	@Id
	private Long mobileNo;
	

	private String cname;
	private String callerTune;

	@Version
	private Integer versionCount;

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

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	@Override
	public String toString() {
		return "MobileCustomer [mobileNo=" + mobileNo + ", cname=" + cname + ", callerTune=" + callerTune
				+ ", versionCount=" + versionCount + "]";
	}


}