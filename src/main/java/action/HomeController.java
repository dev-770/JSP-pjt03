package action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.NoticeDao;
import dto.NoticeDto;
import process.Paging;

public class HomeController implements Controller {

	@Override
	public String handleGet(HttpServletRequest req, HttpServletResponse resp) {
		return process(req, resp);
	}

	@Override
	public String handlePost(HttpServletRequest req, HttpServletResponse resp) {
		return process(req, resp);
	}
	private String process(HttpServletRequest req, HttpServletResponse resp) {
		/* 쿠키 로그인 유지 */
		Cookie[] cookie = req.getCookies();
		if(cookie != null)
			for(Cookie cf: cookie) {
				if(cf.getName().equals("id")) {
					HttpSession session = req.getSession();
					session.setAttribute("sessionID", cf.getValue()); // 쿠키 값을 세션에 저장
				}
			}
		
		NoticeDao nDao = NoticeDao.getInstance();
		Paging page = new Paging();
		
		page.setRowSize(8); // 한 화면에 보여줄 게시글 행 수 셋팅값 변경가능
		page.setPg(1); // 현재 페이지

		page.setStart((page.getPg() * page.getRowSize()) - (page.getRowSize() - 1)); // list 시작
		page.setEnd((page.getPg() * page.getRowSize())); // list 끝

		page.setTotal(nDao.getTotal()); // 전체 게시글 수
		List<NoticeDto> list = nDao.selectList(page.getStart(), page.getEnd(), null);
		
		req.setAttribute("list", list);
		return "index";
	}
}
