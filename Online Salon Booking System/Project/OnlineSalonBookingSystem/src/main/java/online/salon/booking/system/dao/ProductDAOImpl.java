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

import online.salon.booking.system.dto.CartDTO;
import online.salon.booking.system.dto.ProductDTO;
import online.salon.booking.system.exception.DuplicateRecordException;

@Repository
public class ProductDAOImpl implements ProductDAOInt{
	
	 @Autowired
     public EntityManager entitymanger;

	@Override
	public long add(ProductDTO dto) throws DuplicateRecordException {
		Session session = entitymanger.unwrap(Session.class);
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public void Update(ProductDTO dto) throws DuplicateRecordException {
		Session session = entitymanger.unwrap(Session.class);
		session.merge(dto);
		
	}

	@Override
	public void Delete(long id) {
		Session session = (Session) entitymanger.unwrap(Session.class);
		Query<ProductDTO> query = session.createQuery("delete from ProductDTO where id= "+id+"");
	    query.executeUpdate();
		
	}

	@Override
	public List<ProductDTO> list() {
		Session session = entitymanger.unwrap(Session.class);
		Query<ProductDTO> query = session.createQuery("from ProductDTO", ProductDTO.class);
		List<ProductDTO> list = query.getResultList();
		return list;
	}

	@Override
	public ProductDTO FindByPk(long pk) {
		Session session = entitymanger.unwrap(Session.class);
		ProductDTO dto = session.get(ProductDTO.class, pk);
		return dto;
	}

	@Override
	public ProductDTO FindByProductName(String productName) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ProductDTO.class);
		criteria.add(Restrictions.eq("productName", productName));
		ProductDTO dto =  (ProductDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public List<ProductDTO> search(ProductDTO dto) {
		Session session = entitymanger.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ProductDTO.class);
		if (dto != null) {
			if (dto.getId()>0) {
              criteria.add(Restrictions.eq("id", dto.getId()));
			}
//			if (dto.getServiceName() != null && dto.getServiceName().length()>0) {
//				criteria.add(Restrictions.like("serviceName", dto.getServiceName() + "%"));
//			}
			if (dto.getProductName() != null && dto.getProductName().length()>0) {
				criteria.add(Restrictions.like("productName", dto.getProductName() + "%"));
			}
		}
		return criteria.list();
	}

	@Override
	public Blob getImageById(long id) throws SerialException, SQLException {
		Session session = entitymanger.unwrap(Session.class);
		ProductDTO person = (ProductDTO) session.get(ProductDTO.class, id);
		byte[] blob = person.getImage();
		Blob bBlob = new SerialBlob(blob);
		return bBlob;
	}

	@Override
	public List<ProductDTO> productlist(long serviceid) {
		System.out.println("in DAO");
		Session session = entitymanger.unwrap(Session.class);
		Query<ProductDTO> query = session.createQuery("from ProductDTO as b where b.serviceid = ?1 ", ProductDTO.class);
		query.setParameter(1, serviceid);
		List<ProductDTO> Rlist = query.getResultList();
		return Rlist;
	}
	
	

}
