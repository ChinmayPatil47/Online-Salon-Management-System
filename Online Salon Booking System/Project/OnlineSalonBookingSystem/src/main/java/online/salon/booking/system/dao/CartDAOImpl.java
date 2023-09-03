package online.salon.booking.system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import online.salon.booking.system.dto.CartDTO;
import online.salon.booking.system.exception.DuplicateRecordException;

@Repository
public class CartDAOImpl implements CartDAOInt{
	
	
	@Autowired
    public EntityManager entitymanger;

	@Override
	public long add(CartDTO dto) throws DuplicateRecordException {
		Session session = entitymanger.unwrap(Session.class);
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public void Update(CartDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void Delete(long id) {
		Session session = (Session) entitymanger.unwrap(Session.class);
		Query<CartDTO> query = session.createQuery("delete from CartDTO where id= "+id+"");
	    query.executeUpdate();	
		
	}

	@Override
	public List<CartDTO> list() {
		Session session = entitymanger.unwrap(Session.class);
		Query<CartDTO> query = session.createQuery("from CartDTO", CartDTO.class);
		List<CartDTO> list = query.getResultList();
		return list;
	}

	@Override
	public List<CartDTO> userorderlist(long userid) {
		System.out.println("in DAO");
		Session session = entitymanger.unwrap(Session.class);
		Query<CartDTO> query = session.createQuery("from CartDTO as b where b.userid = ?1 ", CartDTO.class);
		query.setParameter(1, userid);
		List<CartDTO> Rlist = query.getResultList();
		return Rlist;
	}

	@Override
	public CartDTO FindByPk(long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO FindByOrderId(String order,long userID) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(CartDTO.class);
		criteria.add(Restrictions.eq("productname", order));
		criteria.add(Restrictions.eq("userid",userID));
		CartDTO dto =  (CartDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public List<CartDTO> search(CartDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Cancle(long id, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Confirm(long id, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Paid(long id, String status) {
		// TODO Auto-generated method stub
		
	}

}
