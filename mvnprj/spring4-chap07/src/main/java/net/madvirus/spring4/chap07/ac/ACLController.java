package net.madvirus.spring4.chap07.ac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ACLController {

	private AclService aclService;

	@RequestMapping("/acl/list")
	public String list(Model model) {
		model.addAttribute("aclList", aclService.getAclList());
		return "acl/aclList";
	}

	@RequestMapping("/acl/modify")
	public String modify(AclModRequest modReq) {
		List<AccessPerm> perms = new ArrayList<>();
		for (AccessPerm reqPerm : modReq.getPerms())
			if (reqPerm.hasData())
				perms.add(reqPerm);
		modReq.setPerms(perms);

		aclService.modifyAccessControll(modReq);
		return "redirect:/acl/list";
	}

	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}

}
