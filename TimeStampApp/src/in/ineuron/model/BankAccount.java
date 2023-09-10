package in.ineuron.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accNo;
	private String holderName;
	private Integer balance;
	private String AccountType;
	
	@CreationTimestamp
	private LocalDateTime openingDate;

	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	@Version
	Integer updateCount;
	
	
	public Integer getAccNo() {
		return accNo;
	}
	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public LocalDateTime getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}
	public LocalDateTime getUpdateDate() {
		return lastUpdate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.lastUpdate = updateDate;
	}
	public Integer getUpdateCount() {
		return updateCount;
	}
	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", holderName=" + holderName + ", balance=" + balance + ", AccountType="
				+ AccountType + ", openingDate=" + openingDate + ", updateDate=" + lastUpdate + ", updateCount="
				+ updateCount + "]";
	}
	
}
