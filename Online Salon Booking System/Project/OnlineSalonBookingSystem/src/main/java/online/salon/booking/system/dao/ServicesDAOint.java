package online.salon.booking.system.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import online.salon.booking.system.dto.ServicesDTO;
import online.salon.booking.system.exception.DuplicateRecordException;

public interface ServicesDAOint {
	
	public long add(ServicesDTO dto) throws DuplicateRecordException;

	public void Update(ServicesDTO dto) throws DuplicateRecordException;

	public void Delete(long id);

	public List<ServicesDTO> list();
	
	public List<ServicesDTO> servicelist(String gender);

	public ServicesDTO FindByPk(long pk);

	public ServicesDTO FindByServiceName(String serviceName);

	public List<ServicesDTO> search(ServicesDTO dto);
	
	public Blob getImageById(long id) throws SerialException, SQLException;

}
