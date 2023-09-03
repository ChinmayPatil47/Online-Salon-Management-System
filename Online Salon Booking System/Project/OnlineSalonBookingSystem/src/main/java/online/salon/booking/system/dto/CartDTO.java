package online.salon.booking.system.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cart")
public class CartDTO extends BaseDTO{
	
	@Column(name = "productname",length = 200)
	private String productname;
	
	@Column(name = "servicecharge")
	private long servicecharge;
	
	@Column(name = "totalcharge")
	private long totalcharge;
	
	@Column(name = "userName",length = 200)
	private String userName;
	
	@Column(name = "userid",length = 200)
	private long userid;
	
	private String status;
	

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}
	
	

}
