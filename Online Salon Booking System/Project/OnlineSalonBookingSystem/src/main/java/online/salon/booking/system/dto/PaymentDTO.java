package online.salon.booking.system.dto;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "payment")
public class PaymentDTO extends BaseDTO{
	
	
	private String orderid;
	
	private long payment;
	
	private String cardnumber;
	
	private String cvv;
	
	private String expairydate;
	
    private long userid;
    
    private String username;
    
    private String status;

	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
