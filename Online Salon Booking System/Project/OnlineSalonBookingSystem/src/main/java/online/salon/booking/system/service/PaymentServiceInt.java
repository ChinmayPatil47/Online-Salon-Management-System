package online.salon.booking.system.service;

import java.util.List;

import online.salon.booking.system.dto.PaymentDTO;
import online.salon.booking.system.exception.DuplicateRecordException;

public interface PaymentServiceInt {
	
	public long add(PaymentDTO dto) throws DuplicateRecordException;

	public void Update(PaymentDTO dto) throws DuplicateRecordException;

	public void Delete(long id);

	public List<PaymentDTO> list();
	
	public List<PaymentDTO> userpaymentlist(long userid);

	public PaymentDTO FindByPk(long pk);

	public PaymentDTO cardNumber(String cardnumber);

	public List<PaymentDTO> search(PaymentDTO dto);


}
