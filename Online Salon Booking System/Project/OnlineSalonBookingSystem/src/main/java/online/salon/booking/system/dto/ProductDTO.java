package online.salon.booking.system.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "product")
public class ProductDTO extends BaseDTO{
	
	@Column(name = "productName",length = 255)
	private String productName;
	@Column(name = "price",length = 255)
	private long price;
	@Column(name = "serviceName",length = 255)
	private String serviceName;
	
	@ManyToOne
	private ServicesDTO service;
	
	private long serviceid;
	
	@Column(name = "image")
	private byte[] image;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
