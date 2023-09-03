package online.salon.booking.system.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import online.salon.booking.system.dto.CartDTO;
import online.salon.booking.system.dto.ProductDTO;
import online.salon.booking.system.exception.DuplicateRecordException;

public interface ProductInt {
	
	public long add(ProductDTO dto) throws DuplicateRecordException;

	public void Update(ProductDTO dto) throws DuplicateRecordException;

	public void Delete(long id);

	public List<ProductDTO> list();
	
	public List<ProductDTO> productlist(long serviceid);

	public ProductDTO FindByPk(long pk);

	public ProductDTO FindByProductName(String productName);

	public List<ProductDTO> search(ProductDTO dto);
	
	public Blob getImageById(long id) throws SerialException, SQLException;

}
