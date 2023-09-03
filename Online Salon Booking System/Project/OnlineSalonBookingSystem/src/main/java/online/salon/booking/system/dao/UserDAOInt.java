package online.salon.booking.system.dao;

import java.util.List;

import online.salon.booking.system.dto.UserDTO;




public interface UserDAOInt {

	public long add(UserDTO dto);

	public void Update(UserDTO dto);

	public void Delete(long id);

	public List<UserDTO> list();

	public UserDTO FindByPk(long pk);

	public UserDTO FindByEmail(String email);

	public UserDTO Authentication(UserDTO dto);

	public List<UserDTO> search(UserDTO dto);
	
	public UserDTO FindByAccountnumber(String accountnumber);
	
}
