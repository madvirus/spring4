package net.madvirus.spring4.chap07.ac;

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
		System.out.printf("modReq.length: %d\n", modReq.getPerms().size());
		for (int i = 0 ; i < modReq.getPerms().size() ; i++) {
			System.out.printf("mod[%d]=%s\n", i, modReq.getPerms().get(i));
		}
		//aclService.modifyAccessControll(modReq);
		return "redirect:/acl/list";
	}

	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}

}
