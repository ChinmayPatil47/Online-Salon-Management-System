package online.salon.booking.system.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.salon.booking.system.dao.UserDAOInt;
import online.salon.booking.system.dto.UserDTO;
import online.salon.booking.system.exception.DuplicateRecordException;


@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	public UserDAOInt dao;

	@Override
	public long add(UserDTO dto) throws DuplicateRecordException {
		UserDTO exisBean = dao.FindByEmail(dto.getEmail());
		if (exisBean != null){
			throw new DuplicateRecordException("Email Id is Already Exist");
		}
		
		long pk = dao.add(dto);
		return pk;
	}

	@Override
	@Transactional
	public void Update(UserDTO dto) throws DuplicateRecordException {
		dao.Update(dto);
	}

	@Override
	@Transactional
	public void Delete(long id) {
		dao.Delete(id);
	}

	@Override
	public List<UserDTO> list() {
		  List<UserDTO> list =  dao.list();
		  return list;
	}

	@Override
	public UserDTO FindByPk(long pk) {
		UserDTO dto = dao.FindByPk(pk);
		return dto;
	}

	@Override
	public UserDTO FindByEmail(String email) {
		UserDTO dto = dao.FindByEmail(email);
		return dto;
	}

	@Override
	public UserDTO Authentication(UserDTO dto) {
		dto = dao.Authentication(dto);
		return dto;
	}

	@Override
	public List<UserDTO> search(UserDTO dto) {
		 List<UserDTO> list =  dao.search(dto);
		 return list;
	}

	@Override
	public UserDTO FindByAccountnumber(String accountnumber) {
		UserDTO dto = dao.FindByAccountnumber(accountnumber);
		return dto;
	}
	
	@Override
	@Transactional
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
		UserDTO dtoExist = FindByPk(id);
		if (dtoExist != null && dtoExist.getPassword().equals(oldPassword)) {
			dtoExist.setPassword(newPassword);
			dao.Update(dtoExist);
			return true;
		} else {
			return false;
		}
	}

}
