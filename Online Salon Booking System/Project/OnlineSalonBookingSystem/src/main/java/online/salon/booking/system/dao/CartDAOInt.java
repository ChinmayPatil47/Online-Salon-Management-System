package online.salon.booking.system.dao;

import java.util.List;

import online.salon.booking.system.dto.CartDTO;
import online.salon.booking.system.exception.DuplicateRecordException;

public interface CartDAOInt {
	
	public long add(CartDTO dto) throws DuplicateRecordException;

	public void Update(CartDTO dto) throws DuplicateRecordException;

	public void Delete(long id);

	public List<CartDTO> list();
	
	public List<CartDTO> userorderlist(long userid);

	public CartDTO FindByPk(long pk);

	public CartDTO FindByOrderId(String order,long userID);

	public List<CartDTO> search(CartDTO dto);
	
	public void Cancle(long id,String status);
	
	public void Confirm(long id,String status);
	
	public void Paid(long id,String status);

}
