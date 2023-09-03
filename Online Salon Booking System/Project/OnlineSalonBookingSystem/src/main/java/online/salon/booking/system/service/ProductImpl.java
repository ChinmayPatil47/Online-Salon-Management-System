package online.salon.booking.system.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.salon.booking.system.dao.ProductDAOInt;
import online.salon.booking.system.dto.CartDTO;
import online.salon.booking.system.dto.ProductDTO;
import online.salon.booking.system.exception.DuplicateRecordException;


@Service
public class ProductImpl implements ProductInt{
	
	@Autowired
	public ProductDAOInt dao;


	@Override
	public long add(ProductDTO dto) throws DuplicateRecordException {
		ProductDTO exisBean = dao.FindByProductName(dto.getProductName());
		if (exisBean != null){
			throw new DuplicateRecordException("This Product is Already Exist");
		}
		
		long pk = dao.add(dto);
		return pk;
	}

	@Override
	@Transactional
	public void Update(ProductDTO dto) throws DuplicateRecordException {
		dao.Update(dto);
	}

	@Override
	@Transactional
	public void Delete(long id) {
		dao.Delete(id);
	}

	@Override
	public List<ProductDTO> list() {
		 List<ProductDTO> list =  dao.list();
		  return list;
	}

	@Override
	public ProductDTO FindByPk(long pk) {
		ProductDTO dto = dao.FindByPk(pk);
		return dto;
	}

	@Override
	public ProductDTO FindByProductName(String productName) {
		ProductDTO dto = dao.FindByProductName(productName);
		return dto;
	}

	@Override
	public List<ProductDTO> search(ProductDTO dto) {
		 List<ProductDTO> list =  dao.search(dto);
		 return list;
	}

	@Override
	@Transactional
	public Blob getImageById(long id) throws SerialException, SQLException {
		return dao.getImageById(id);
	}

	@Override
	public List<ProductDTO> productlist(long serviceid) {
		 List<ProductDTO> list =  dao.productlist(serviceid);
			return list;
	}

}
