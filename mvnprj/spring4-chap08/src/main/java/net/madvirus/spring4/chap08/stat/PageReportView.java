package net.madvirus.spring4.chap08.stat;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PageReportView extends AbstractPdfView {
	private String fontPath = "c:\\windows\\Fonts\\malgun.ttf";

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRankList");
		Table table = new Table(2, pageRanks.size() + 1);
		table.setPadding(5);

		BaseFont bfKorean = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H,
				BaseFont.EMBEDDED);

		Font font = new Font(bfKorean);
		Cell cell = new Cell(new Paragraph("순위", font));
		cell.setHeader(true);
		table.addCell(cell);
		cell = new Cell(new Paragraph("페이지", font));
		table.addCell(cell);
		table.endHeaders();

		for (PageRank rank : pageRanks) {
			table.addCell(Integer.toString(rank.getRank()));
			table.addCell(rank.getPage());
		}
		document.add(table);
	}

	public void setFontPath(String fontPath) {
		this.fontPath = fontPath;
	}

}
