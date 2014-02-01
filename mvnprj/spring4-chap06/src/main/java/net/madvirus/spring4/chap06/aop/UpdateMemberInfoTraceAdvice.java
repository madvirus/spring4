package net.madvirus.spring4.chap06.aop;

import net.madvirus.spring4.chap06.member.UpdateInfo;

public class UpdateMemberInfoTraceAdvice {

	public void traceReturn(String memberId, UpdateInfo info) {
		System.out.printf("[TA] 정보 수정: 대상회원=%s, 수정정보=%s\n",
				memberId, info);
	}

}
