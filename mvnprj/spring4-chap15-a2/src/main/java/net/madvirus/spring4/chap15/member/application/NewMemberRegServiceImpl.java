package net.madvirus.spring4.chap15.member.application;

import net.madvirus.spring4.chap15.member.domain.Member;
import net.madvirus.spring4.chap15.member.domain.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class NewMemberRegServiceImpl implements NewMemberRegService {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	@Override
	public Long register(NewMemberRequest req) {
		if (memberRepository.findByUserId(req.getUserId()) != null) {
			throw new DuplicateUserIdException();
		}
		if (memberRepository.findByEmail(req.getEmail()) != null) {
			throw new DuplicateEmailException();
		}
		Member m = new Member(req.getUserId(), req.getPassword(), req.getEmail(), req.getName());
		memberRepository.save(m);
		return m.getId();
	}

	public void setMemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

}
