package practice.springbatch.csvtodb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String number;
	private Double amount;
	private Double discount;
	private Double finalAmount;
	private String location;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public Double getAmount() {
		return amount;
	}
	public Double getDiscount() {
		return discount;
	}
	public Double getFinalAmount() {
		return finalAmount;
	}
	public String getLocation() {
		return location;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}