package net.madvirus.spring4.chap07.ac;

import java.util.List;

public class AclModRequest {

	private List<AccessPerm> perms;

	public List<AccessPerm> getPerms() {
		return perms;
	}

	public void setPerms(List<AccessPerm> permissions) {
		this.perms = permissions;
	}

}
