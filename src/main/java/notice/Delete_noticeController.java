package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dao.NoticeDao;

public class Delete_noticeController implements Controller {

	@Override
	public String handlePost(HttpServletRequest req, HttpServletResponse resp) {
		return process(req, resp);
	}

	@Override
	public String handleGet(HttpServletRequest req, HttpServletResponse resp) {
		return process(req, resp);
	}
	
	private String process(HttpServletRequest req, HttpServletResponse resp) {
		int idx = Integer.parseInt(req.getParameter("idx"));
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.delete(idx);
		
		return "notice.do";
	}
	
}
