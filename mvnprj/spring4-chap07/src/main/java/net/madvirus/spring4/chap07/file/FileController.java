package net.madvirus.spring4.chap07.file;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileController {

	@RequestMapping("/files/{fileId:[a-zA-Z]\\d{3}}")
	public String fileInfo(@PathVariable String fileId) {
		return "files/fileInfo";
	}

	@RequestMapping("/files/?*.download")
	public String fileInfo(HttpServletRequest request) {
		return "files/fileDownload";
	}

	@RequestMapping("/folders/**/files")
	public String list(HttpServletRequest request, Model model) {
		String uri = request.getRequestURI();
		if (uri.endsWith("/folders/files")) {
			model.addAttribute("folderIds", new String[0]);
		} else {
			String ctxPath = request.getContextPath();
			String path = ctxPath.isEmpty() ? uri : uri.substring(ctxPath.length());
			String folderTreePath = path.substring("/folders/".length(), path.length() - "/files".length());
			String[] folderIds = folderTreePath.split("/");
			model.addAttribute("folderIds", folderIds);
		}
		return "files/filesInFolder";
	}
}
