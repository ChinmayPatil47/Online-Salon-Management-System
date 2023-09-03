package online.salon.booking.system.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.salon.booking.system.dto.ProductDTO;
import online.salon.booking.system.dto.ServicesDTO;


@Repository
public class ServicesDAOimpl implements ServicesDAOint{
	
	 @Autowired
     public EntityManager entitymanger;
     
	@Override
	public long add(ServicesDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public void Update(ServicesDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		session.merge(dto);
	}

	@Override
	public void Delete(long id) {
		Session session = (Session) entitymanger.unwrap(Session.class);
		Query<ServicesDTO> query = session.createQuery("delete from ServicesDTO where id= "+id+"");
	    query.executeUpdate();
	}

	@Override
	public List<ServicesDTO> list() {
		Session session = entitymanger.unwrap(Session.class);
		Query<ServicesDTO> query = session.createQuery("from ServicesDTO", ServicesDTO.class);
		List<ServicesDTO> list = query.getResultList();
		return list;
	}

	@Override
	public ServicesDTO FindByPk(long pk) {
		Session session = entitymanger.unwrap(Session.class);
		ServicesDTO dto = session.get(ServicesDTO.class, pk);
		return dto;
	}
	

	@Override
	public List<ServicesDTO> search(ServicesDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ServicesDTO.class);
		if (dto != null) {
			if (dto.getId()>0) {
              criteria.add(Restrictions.eq("id", dto.getId()));
			}
//			if (dto.getServiceName() != null && dto.getServiceName().length()>0) {
//				criteria.add(Restrictions.like("serviceName", dto.getServiceName() + "%"));
//			}
			if (dto.getGender() != null && dto.getGender().length()>0) {
				criteria.add(Restrictions.like("gender", dto.getGender() + "%"));
			}
		}
		return criteria.list();
	}

	@Override
	public ServicesDTO FindByServiceName(String serviceName) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ServicesDTO.class);
		criteria.add(Restrictions.eq("serviceName", serviceName));
		ServicesDTO dto =  (ServicesDTO) criteria.uniqueResult();
		return dto;
	}
	
	@Override
	public Blob getImageById(long id) throws SerialException, SQLException {
		Session session = entitymanger.unwrap(Session.class);
		ServicesDTO person = (ServicesDTO) session.get(ServicesDTO.class, id);
		byte[] blob = person.getImage();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}

	@Override
	public List<ServicesDTO> servicelist(String gender) {
		System.out.println("in DAO");
		Session session = entitymanger.unwrap(Session.class);
		Query<ServicesDTO> query = session.createQuery("from ServicesDTO as b where b.gender = ?1 ", ServicesDTO.class);
		query.setParameter(1, gender);
		List<ServicesDTO> Rlist = query.getResultList();
		return Rlist;
	}

}
