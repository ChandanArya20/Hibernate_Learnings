package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable  //It's optional
public class ProgrammerProjId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int pId;
	private int projId;
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	
	@Override
	public String toString() {
		return "ProgrammerProjId [pId=" + pId + ", projId=" + projId + "]";
	}
}
