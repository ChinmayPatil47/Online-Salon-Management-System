package online.salon.booking.system.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.salon.booking.system.dao.ServicesDAOint;
import online.salon.booking.system.dto.ProductDTO;
import online.salon.booking.system.dto.ServicesDTO;
import online.salon.booking.system.exception.DuplicateRecordException;

@Service
public class ServiceImpl implements ServicesInt{

	@Autowired
	public ServicesDAOint dao;

	@Override
	public long add(ServicesDTO dto) throws DuplicateRecordException {
		ServicesDTO exisBean = dao.FindByServiceName(dto.getServiceName());
		if (exisBean != null){
			throw new DuplicateRecordException("This Service is Already Exist");
		}
		
		long pk = dao.add(dto);
		return pk;
	}

	@Override
	@Transactional
	public void Update(ServicesDTO dto) throws DuplicateRecordException {
		dao.Update(dto);
	}

	@Override
	@Transactional
	public void Delete(long id) {
		dao.Delete(id);
	}

	@Override
	public List<ServicesDTO> list() {
		  List<ServicesDTO> list =  dao.list();
		  return list;
	}

	@Override
	public ServicesDTO FindByPk(long pk) {
		ServicesDTO dto = dao.FindByPk(pk);
		return dto;
	}

	@Override
	public List<ServicesDTO> search(ServicesDTO dto) {
		 List<ServicesDTO> list =  dao.search(dto);
		 return list;
	}


	@Override
	public ServicesDTO FindByServiceName(String serviceName) {
		ServicesDTO dto = dao.FindByServiceName(serviceName);
		return dto;
	}
	
	@Override
	@Transactional
	public Blob getImageById(long id) throws SerialException, SQLException {
		return dao.getImageById(id);
	}

	@Override
	public List<ServicesDTO> servicelist(String gender) {
		 List<ServicesDTO> list =  dao.servicelist(gender);
			return list;
	}

	
}
