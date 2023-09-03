package online.salon.booking.system.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import online.salon.booking.system.dto.BaseDTO;
import online.salon.booking.system.dto.UserDTO;

@Setter
@Getter
public class LoginForm extends BaseForm{

	@NotNull(message = "Email Is Required")
	private String email;
	
	@NotNull(message = "Password is Required")
	private String password;
	

	@Override
	public BaseDTO getDTO() {
		UserDTO bean = new UserDTO();
		bean.setEmail(email);
		bean.setPassword(password);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		UserDTO bean = (UserDTO)getDTO();
		email = bean.getEmail();
		password = bean.getPassword();
	}



}
