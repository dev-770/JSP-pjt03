package member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogoutController implements Controller{

	@Override
	public String handlePost(HttpServletRequest req, HttpServletResponse resp) {
		return process(req, resp);
	}

	@Override
	public String handleGet(HttpServletRequest req, HttpServletResponse resp) {
		return process(req, resp);
	}
	
	private String process(HttpServletRequest req, HttpServletResponse resp) {
		/* 세션 초기화 */
		HttpSession session = req.getSession();
		session.invalidate();
		
		/* 쿠키 삭제 */
		Cookie[] c = req.getCookies();
		if(c != null) {
			for(Cookie cf: c) {
				if(cf.getName().equals("id")) {
					cf.setMaxAge(0); // 제거
					cf.setPath("/");
					resp.addCookie(cf);
				}
			}
		}
		return "home.do";
	}
}
