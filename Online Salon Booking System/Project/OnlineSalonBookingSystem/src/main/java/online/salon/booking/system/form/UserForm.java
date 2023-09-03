package online.salon.booking.system.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import online.salon.booking.system.dto.BaseDTO;
import online.salon.booking.system.dto.UserDTO;

@Setter
@Getter
public class UserForm extends BaseForm{
	
	@NotEmpty(message = "UserName is Required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "UserName is Invalid")
	private String userName;
	
	@NotEmpty(message = "Email is Required")
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Email id is invalid")
	private String email;
	
	@NotEmpty(message = "Password is Require")
	//@Pattern(regexp="(^?=.*[A-Z](?=.*[a-z])(?=.*[0-9])(?=.*[\\\\S])[A-Za-z0-9\\\\S]{6,12})*$",message = "Password is invalid")
	private String password;
	
	@NotEmpty(message = "Phone No is Required")
	//@Pattern(regexp="(^[7-9][0-9]{9})*$",message = "Phone No is invalid")
	private String phoneNo;
	
	@NotEmpty(message = "Gender is Required")	
	private String gender;
	
	private long roleid;
	
	private String rolename;
	
	@NotEmpty(message = "Address is Required")
	private String address;
	
	private Date dob;
	
	@Override
	public BaseDTO getDTO() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setUserName(userName);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setPhoneNo(phoneNo);
		dto.setGender(gender);
		dto.setRoleid(2);
		dto.setRolename("User");
		dto.setAddress(address);
		dto.setDob(dob);
		return dto;
	}


	@Override
	public void populate(BaseDTO bDto) {
		UserDTO dto=(UserDTO) bDto;
		id = dto.getId();
		userName = dto.getUserName();
		email = dto.getEmail();
		password = dto.getPassword();
		phoneNo = dto.getPhoneNo();
		gender = dto.getGender();
		address = dto.getAddress();
		dob = dto.getDob();
	}
		


}
