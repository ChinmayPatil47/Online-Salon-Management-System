package online.salon.booking.system.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.salon.booking.system.dto.PaymentDTO;
import online.salon.booking.system.exception.DuplicateRecordException;


@Repository
public class PaymentDAOImpl implements PaymentDAOInt{
	
	@Autowired
    public EntityManager entitymanger;

	@Override
	public long add(PaymentDTO dto) throws DuplicateRecordException {
		Session session = entitymanger.unwrap(Session.class);
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public void Update(PaymentDTO dto) throws DuplicateRecordException {
		Session session = entitymanger.unwrap(Session.class);
		session.merge(dto);	
		
	}

	@Override
	public void Delete(long id) {
		Session session = (Session) entitymanger.unwrap(Session.class);
		Query<PaymentDTO> query = session.createQuery("delete from PaymentDTO where id= "+id+"");
	    query.executeUpdate();
		
	}

	@Override
	public List<PaymentDTO> list() {
		Session session = entitymanger.unwrap(Session.class);
		Query<PaymentDTO> query = session.createQuery("from PaymentDTO", PaymentDTO.class);
		List<PaymentDTO> list = query.getResultList();
		return list;
	}

	@Override
	public List<PaymentDTO> userpaymentlist(long userid) {
		System.out.println("in DAO");
		Session session = entitymanger.unwrap(Session.class);
		Query<PaymentDTO> query = session.createQuery("from PaymentDTO as b where b.userid = ?1 ", PaymentDTO.class);
		query.setParameter(1, userid);
		List<PaymentDTO> Rlist = query.getResultList();
		return Rlist;
	}

	@Override
	public PaymentDTO FindByPk(long pk) {
		Session session = entitymanger.unwrap(Session.class);
		PaymentDTO dto = session.get(PaymentDTO.class, pk);
		return dto;
	}

	@Override
	public PaymentDTO cardNumber(String cardnumber) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PaymentDTO.class);
		criteria.add(Restrictions.eq("cardnumber", cardnumber));
		PaymentDTO dto =  (PaymentDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public List<PaymentDTO> search(PaymentDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(PaymentDTO.class);
		if (dto != null) {
			if (dto.getId()>0) {
              criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getUsername() != null && dto.getUsername().length()>0) {
				criteria.add(Restrictions.like("username", dto.getUsername() + "%"));
			}
		}
		return criteria.list();
	}
}
