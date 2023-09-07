package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity(name="account_details")
@SQLDelete(sql = "UPDATE account_details SET status='closed' WHERE accNum=?")
public class Account {

	@Id
	int id;
	int accNum;
	String accHolder;
	String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccNo() {
		return accNum;
	}
	public void setAccNo(int accNo) {
		this.accNum = accNo;
	}
	public String getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accNo=" + accNum + ", accHolder=" + accHolder + ", status=" + status + "]";
	}
	
}
