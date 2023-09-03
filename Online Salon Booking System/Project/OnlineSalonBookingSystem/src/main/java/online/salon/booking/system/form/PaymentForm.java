package online.salon.booking.system.form;

import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;
import online.salon.booking.system.dto.BaseDTO;
import online.salon.booking.system.dto.PaymentDTO;

@Setter
@Getter
public class PaymentForm extends BaseForm {

	
	@NotNull(message = "Order ID is Required")
	private String orderid;


	@NotNull(message = "Amount is Required")
	private long payment;


	@NotNull(message = "Card Number is Required")
	private String cardnumber;


	@NotNull(message = "CVV Number is Required")
	private String cvv;

	

	@NotNull(message = "Expairy Date is Required")
	private String expairydate;

	private long userid;


	@NotNull(message = "User Name is Required")
	private String username;

	private String status;
	
	
	@Override
	public BaseDTO getDTO() {
		PaymentDTO dto = new PaymentDTO();
		dto.setId(id);
		dto.setOrderid(orderid);
		dto.setPayment(payment);
		dto.setCardnumber(cardnumber);
		dto.setCvv(cvv);
		dto.setExpairydate(expairydate);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		PaymentDTO bean = (PaymentDTO) bDto;
		id = bean.getId();
		orderid = bean.getOrderid();
		payment = bean.getPayment();
		cardnumber = bean.getCardnumber();
		cvv = bean.getCvv();
		expairydate =bean.getExpairydate();
	}

}

