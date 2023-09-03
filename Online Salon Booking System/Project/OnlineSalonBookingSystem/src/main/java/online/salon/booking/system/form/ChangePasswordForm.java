package online.salon.booking.system.form;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import online.salon.booking.system.dto.BaseDTO;

@Getter
@Setter
public class ChangePasswordForm extends BaseForm  {

	@NotEmpty(message = "Old Password is required")
	private String oldPassword;
	
	@NotEmpty(message = "Confirm Password is required")
	private String confirmPassword;
	
	@NotEmpty(message = "New Passeword is required")
	private String newPassword;

	

	@Override
	public BaseDTO getDTO() {
		return null;
	}

	@Override
	public void populate(BaseDTO bDto) {
	}
	
}
