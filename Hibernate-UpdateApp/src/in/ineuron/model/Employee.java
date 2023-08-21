package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate(value=true)
public class Employee {
	
	@Id
	private int id;	
	private String name;
	private String address;
	private int salary;
	
	public Employee() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}	
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}
}
