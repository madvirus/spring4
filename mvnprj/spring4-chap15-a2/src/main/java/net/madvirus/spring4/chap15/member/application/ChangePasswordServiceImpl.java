package net.madvirus.spring4.chap15.member.application;

import net.madvirus.spring4.chap15.member.domain.Member;
import net.madvirus.spring4.chap15.member.domain.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordServiceImpl implements ChangePasswordService {

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	@Override
	public void changePassword(ChangePasswordRequest req) {
		Member member = memberRepository.findOne(req.getMemberId());
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(req.getCurrentPassword(), req.getNewPassword());
	}

}
