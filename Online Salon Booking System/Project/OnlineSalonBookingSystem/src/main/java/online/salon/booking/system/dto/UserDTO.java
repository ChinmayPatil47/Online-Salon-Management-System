package online.salon.booking.system.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "USER")
public class UserDTO extends BaseDTO{

	@Column(name = "USERNAME",length = 255)
	private String userName;
	@Column(name = "EMAIL",length = 255)
	private String email;
	@Column(name = "PASSWORD",length = 255)
	private String password;
	@Column(name = "GENDER",length = 255)
	private String gender;
	@Column(name = "PHONENO",length = 255)
	private String phoneNo;
	@Column(name = "ROLE_ID",length = 255)
	private long roleid;
	@Column(name = "ROLE_NAME",length = 255)
	private String rolename;
	@Column(name = "address",length = 3000)
	private String address;
	@Column(name = "DOB")
	private Date dob;
	
	
	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return userName;
	}

}
