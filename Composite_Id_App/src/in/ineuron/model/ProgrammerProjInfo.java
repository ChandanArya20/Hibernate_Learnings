package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProgrammerProjId id;
	private String pName;
	private int deptNo;
	private String projName;
	
	public ProgrammerProjId getId() {
		return id;
	}
	public void setId(ProgrammerProjId id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
	@Override
	public String toString() {
		return "ProgrammerProjInfo [id=" + id + ", pName=" + pName + ", deptNo=" + deptNo + ", projName=" + projName
				+ "]";
	}
		
}
