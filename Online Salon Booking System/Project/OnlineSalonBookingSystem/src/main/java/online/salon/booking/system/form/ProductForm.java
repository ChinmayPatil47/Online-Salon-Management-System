package online.salon.booking.system.form;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import online.salon.booking.system.dto.BaseDTO;
import online.salon.booking.system.dto.ProductDTO;


@Getter
@Setter
public class ProductForm extends BaseForm{
	
	@NotNull(message = "Product Name is required")
	private String productName;
	
	private long price;
	
	private String serviceName;
	
	private long serviceid;
	
	private MultipartFile image;

	@Override
	public BaseDTO getDTO() {
		ProductDTO dto = new ProductDTO();
		dto.setId(id);
		dto.setServiceName(serviceName);
		dto.setPrice(price);
		dto.setProductName(productName);
		dto.setServiceid(serviceid);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		ProductDTO dto = (ProductDTO) bDto;
		id = dto.getId();
		serviceName = dto.getServiceName();
		price = dto.getPrice();
		productName = dto.getProductName();
		serviceid = dto.getServiceid();
	}

}
