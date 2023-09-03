package online.salon.booking.system.form;


import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import online.salon.booking.system.dto.BaseDTO;
import online.salon.booking.system.dto.CartDTO;


@Getter
@Setter
public class CartForm extends BaseForm{
	
	private String productname;
	
	private long servicecharge;
	
	private long totalcharge;
	
	private String userName;
	
	private long userid;
	
	private String status;
	

	@Override
	public BaseDTO getDTO() {
		CartDTO dto = new CartDTO();
		dto.setId(id);
		dto.setProductname(productname);
		dto.setServicecharge(servicecharge);
		dto.setTotalcharge(totalcharge);
		dto.setUserName(userName);
		dto.setUserid(userid);
		dto.setStatus(status);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		CartDTO dto=(CartDTO) bDto;
		id = dto.getId();
		productname =dto.getProductname();
		servicecharge = dto.getServicecharge();
		totalcharge = dto.getTotalcharge();
		userName = dto.getUserName();
		userid = dto.getUserid();
		status = dto.getStatus();
	}

}
