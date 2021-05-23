package notice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dao.NoticeDao;
import dto.NoticeDto;
import process.Paging;

public class Search_noticeController implements Controller {

	@Override
	public String handlePost(HttpServletRequest req, HttpServletResponse resp) {
		return process(req, resp);
	}

	@Override
	public String handleGet(HttpServletRequest req, HttpServletResponse resp) {
		return process(req, resp);
	}
	
	private String process(HttpServletRequest req, HttpServletResponse resp) {
		String search = req.getParameter("board_search");
		
		NoticeDao nDao = NoticeDao.getInstance();
		Paging page = new Paging();
		String strPg = req.getParameter("pg");

		/* paging, list 처리 */
		page.makePaging(strPg, search);
		List<NoticeDto> list = nDao.selectList(page.getStart(), page.getEnd(), search);
		List<Paging> pg = new ArrayList<Paging>();
		pg.add(page);
		
		req.setAttribute("list", list);
		req.setAttribute("pg", pg);
		req.setAttribute("search", search);
		
		return "notice";
	}
}
