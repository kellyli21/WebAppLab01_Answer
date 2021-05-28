package ch01.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch01.dao.MemberDao;
import ch01.model.MemberBean;

//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
@Repository
public class MemberHibernateDaoImpl implements MemberDao  {
	//String resource = "java:comp/env/jdbc/memberDB";
	@Autowired
	SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isDup(String id) {
		boolean result = false;
		String hql = "FROM MemberBean m where m.memberId = :id";
		Session session = factory.getCurrentSession();
		List<MemberBean> beans = session.createQuery(hql)
				                        .setParameter("id", id)
				                        .getResultList();
		if (beans.size() == 0) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	@Override
	public int save(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.save(mb);
		return ++count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> getAllMembers() {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean";
		List<MemberBean> list = session.createQuery(hql)
				                       .getResultList();
		return list;
	}

	@Override
	public MemberBean getMember(int pk) {
		Session session = factory.getCurrentSession();
		MemberBean mb = session.get(MemberBean.class, pk);
		return mb;
		
	}

	@Override
	public int deleteMember(int pk) {
		int count = 0;
		Session session = factory.getCurrentSession();
		MemberBean mb = new MemberBean();
		mb.setId(pk);
		session.delete(mb);
		return ++count;
	}

	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
		return ++count;
	}
}
