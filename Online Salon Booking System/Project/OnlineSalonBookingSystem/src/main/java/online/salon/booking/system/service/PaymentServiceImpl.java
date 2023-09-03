package online.salon.booking.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.salon.booking.system.dao.PaymentDAOInt;
import online.salon.booking.system.dto.PaymentDTO;
import online.salon.booking.system.exception.DuplicateRecordException;



@Service
public class PaymentServiceImpl implements PaymentServiceInt{
	
	
	@Autowired
	private PaymentDAOInt dao;

	@Override
	public long add(PaymentDTO dto) throws DuplicateRecordException {
		PaymentDTO exisBean = dao.cardNumber(dto.getCardnumber());
		if (exisBean != null){
			throw new DuplicateRecordException("Card Number is Already Exist");
		}
		long pk = dao.add(dto);
		return pk;

	}

	@Override
	@Transactional
	public void Update(PaymentDTO dto) throws DuplicateRecordException {
		dao.Update(dto);
		
	}

	@Override
	@Transactional
	public void Delete(long id) {
		dao.Delete(id);
		
	}

	@Override
	public List<PaymentDTO> list() {
		List<PaymentDTO> list =  dao.list();
		  return list;
	}

	@Override
	public List<PaymentDTO> userpaymentlist(long userid) {
		 List<PaymentDTO> list =  dao.userpaymentlist(userid);
			return list;	}

	@Override
	public PaymentDTO FindByPk(long pk) {
		PaymentDTO dto = dao.FindByPk(pk);
		return dto;
	}

	@Override
	public PaymentDTO cardNumber(String cardnumber) {
		PaymentDTO order = dao.cardNumber(cardnumber);
		return order;
	}

	@Override
	public List<PaymentDTO> search(PaymentDTO dto) {
		 List<PaymentDTO> list =  dao.search(dto);
		 return list;
	}

}
