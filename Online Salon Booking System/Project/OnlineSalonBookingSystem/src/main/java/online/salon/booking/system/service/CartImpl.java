package online.salon.booking.system.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.salon.booking.system.dao.CartDAOInt;
import online.salon.booking.system.dto.CartDTO;
import online.salon.booking.system.exception.DuplicateRecordException;


@Service
public class CartImpl implements CartInt{
	
	@Autowired
	private CartDAOInt dao;


	@Override
	public long add(CartDTO dto) throws DuplicateRecordException {
		CartDTO exisBean = dao.FindByOrderId(dto.getProductname(),dto.getUserid());
		if (exisBean != null){
			throw new DuplicateRecordException("Already exist this Product");
		}
		long pk = dao.add(dto);
		return pk;
	}

	@Override
	public void Update(CartDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void Delete(long id) {
		dao.Delete(id);		
	}

	@Override
	public List<CartDTO> list() {
		List<CartDTO> list =  dao.list();
		  return list;
	}

	@Override
	public List<CartDTO> userorderlist(long userid) {
		 List<CartDTO> list =  dao.userorderlist(userid);
			return list;
	}

	@Override
	public CartDTO FindByPk(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO FindByOrderId(String order,long userID) {
		CartDTO cartDto = dao.FindByOrderId(order,userID);
		return cartDto;
	}

	@Override
	public List<CartDTO> search(CartDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Cancle(long id, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Confirm(long id, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Paid(long id, String status) {
		// TODO Auto-generated method stub
		
	}

}
