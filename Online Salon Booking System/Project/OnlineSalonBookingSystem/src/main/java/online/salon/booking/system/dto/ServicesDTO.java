package online.salon.booking.system.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "services")
public class ServicesDTO extends BaseDTO{
	
	@Column(name = "serviceName",length = 255)
	private String serviceName;
	@Column(name = "GENDER",length = 255)
	private String gender;
	@Column(name = "SHOP_NAME",length = 255)
	private String shopname;
	@Column(name = "address",length = 3000)
	private String address;
	
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
