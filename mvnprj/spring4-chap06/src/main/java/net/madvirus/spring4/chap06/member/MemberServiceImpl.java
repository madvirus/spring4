package net.madvirus.spring4.chap06.member;

public class MemberServiceImpl implements MemberService {

	@Override
	public void regist(MemberRegRequest memberRegReq) {
		System.out.println("MemberServiceImpl.regist() 호출됨");
	}

	@Override
	public boolean update(String id, UpdateInfo updateInfo) {
		System.out.println("MemberServiceImpl.update() 호출됨");
		return true;
	}

}
