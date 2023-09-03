package online.salon.booking.system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.salon.booking.system.dto.UserDTO;




@Repository
public class UserDAOImpl implements UserDAOInt {
	
     @Autowired
     public EntityManager entitymanger;
     
	@Override
	public long add(UserDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public void Update(UserDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		session.merge(dto);
	}

	@Override
	public void Delete(long id) {
		Session session = (Session) entitymanger.unwrap(Session.class);
		Query<UserDTO> query = session.createQuery("delete from UserDTO where id= "+id+"");
	    query.executeUpdate();
	}

	@Override
	public List<UserDTO> list() {
		Session session = entitymanger.unwrap(Session.class);
		Query<UserDTO> query = session.createQuery("from UserDTO", UserDTO.class);
		List<UserDTO> list = query.getResultList();
		return list;
	}

	@Override
	public UserDTO FindByPk(long pk) {
		Session session = entitymanger.unwrap(Session.class);
		UserDTO dto = session.get(UserDTO.class, pk);
		return dto;
	}

	@Override
	public UserDTO FindByEmail(String email) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("email", email));
		UserDTO dto =  (UserDTO) criteria.uniqueResult();
		return dto;
	}
	

	@Override
	public UserDTO Authentication(UserDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		Query<UserDTO> query = session.createQuery("from UserDTO where email=:email and password=:password", UserDTO.class);
		query.setParameter("email",dto.getEmail());
		query.setParameter("password",dto.getPassword());
		dto = null;
		try {
			dto = query.getSingleResult();
		} catch (NoResultException e) {
		}
		return dto;
	}

	@Override
	public List<UserDTO> search(UserDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		if (dto != null) {
			if (dto.getId()>0) {
              criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getEmail() != null && dto.getEmail().length()>0) {
				criteria.add(Restrictions.like("email", dto.getEmail() + "%"));
			}
			
		}
		return criteria.list();
	}

	@Override
	public UserDTO FindByAccountnumber(String accountnumber) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("accountnumber", accountnumber));
		UserDTO dto =  (UserDTO) criteria.uniqueResult();
		return dto;
	}

}
