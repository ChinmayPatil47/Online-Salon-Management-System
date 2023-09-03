package online.salon.booking.system.form;


import lombok.Getter;
import lombok.Setter;
import online.salon.booking.system.dto.BaseDTO;


@Setter
@Getter
public abstract class BaseForm {

	protected long id;

	private String operation;

	public abstract BaseDTO getDTO();

	public abstract void populate(BaseDTO bDto);

}
