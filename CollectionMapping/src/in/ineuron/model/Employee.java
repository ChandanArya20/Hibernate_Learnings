package in.ineuron.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.ListIndexBase;

@Entity(name="employee_records")
public class Employee {

	@Id
	Integer eid;
	String ename;
	String eaddress;
	
	@ElementCollection
	@Column(name="friend_name")
	@CollectionTable(name="emp_friends", joinColumns =  @JoinColumn(name="emp_id",referencedColumnName = "eid"))
	@OrderColumn(name="friend_no")
	@ListIndexBase(1)
	List<String> friendList;
	
	
	@ElementCollection
	@Column(name="mobile_no")
	@CollectionTable(name="emp_phone", joinColumns =  @JoinColumn(name="emp_id",referencedColumnName = "eid"))
	Set<Long> phones;
	
	
	@ElementCollection
	@Column(name="account_number")
	@CollectionTable(name="emp_accounts", joinColumns =  @JoinColumn(name="emp_id",referencedColumnName = "eid"))
	@MapKeyColumn(name="bank_name")
	Map<String, Long> bankAccounts;


	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEaddress() {
		return eaddress;
	}


	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}


	public List<String> getFriendList() {
		return friendList;
	}


	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}


	public Set<Long> getPhones() {
		return phones;
	}


	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}


	public Map<String, Long> getBankAccounts() {
		return bankAccounts;
	}


	public void setBankAccounts(Map<String, Long> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", friendList=" + friendList
				+ ", phones=" + phones + ", bankAccounts=" + bankAccounts + "]";
	}
	
	
	
	
	
}




















