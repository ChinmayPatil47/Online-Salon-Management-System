package online.salon.booking.system.form;


import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;


import lombok.Getter;
import lombok.Setter;
import online.salon.booking.system.dto.BaseDTO;
import online.salon.booking.system.dto.ServicesDTO;


@Getter
@Setter
public class ServicesForm extends BaseForm{
	
	@NotNull(message = "Services Name is required")
	private String serviceName;
	@NotNull(message = "Gender is required")
	private String gender;
	@NotNull(message = "Shop Name is required")
	private String shopname;
	@NotNull(message = "Address is required")
	private String address;
	private MultipartFile image;
	
	
	@Override
	public BaseDTO getDTO() {
		ServicesDTO dto = new ServicesDTO();
		dto.setId(id);
		dto.setServiceName(serviceName);
		dto.setGender(gender);
		dto.setShopname(shopname);
		dto.setAddress(address);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		ServicesDTO dto=(ServicesDTO) bDto;
		id = dto.getId();
		serviceName = dto.getServiceName();
		gender = dto.getGender();
		shopname = dto.getShopname();
		address = dto.getAddress();
	}

}
