package ch01.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch01.dao.MemberDao;
import ch01.model.MemberBean;
import ch01.model.MemberService;

@Service
@Transactional
public class MemberHibernateServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public boolean isDup(String id) {
		return dao.isDup(id);
	}

	@Override
	public int save(MemberBean mb) {
		return dao.save(mb);
	}

	@Override
	public List<MemberBean> getAllMembers() {
		return dao.getAllMembers();
	}

	@Override
	public MemberBean getMember(int pk) {
		return dao.getMember(pk);
	}

	@Override
	public int deleteMember(int ipk) {
		return dao.deleteMember(ipk);
	}

	@Override
	public int updateMember(MemberBean mb) {
		return dao.updateMember(mb);
	}

}
