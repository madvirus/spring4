package net.madvirus.spring4.chap09.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UploadController2 {

	private String uploadPath = System.getProperty("java.io.tmpdir");

	@RequestMapping("/upload/form.do")
	public String form() {
		return "upload/fileUploadForm2";
	}

	@RequestMapping(value = "/upload/servletPart.do", method = RequestMethod.POST)
	public String uploadByMultipartFile(@RequestParam("f") Part part,
			@RequestParam("title") String title, Model model) throws IOException {
		if (part.getSize() > 0) {
			String fileName = getFileName(part);
			File file = new File(uploadPath, fileName);
			FileCopyUtils.copy(part.getInputStream(), new FileOutputStream(file));
			model.addAttribute("title", title);
			model.addAttribute("fileName", fileName);
			model.addAttribute("uploadPath", file.getAbsolutePath());
			return "upload/fileUploaded";
		}
		return "upload/noUploadFile";
	}

	private String getFileName(Part part) {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
