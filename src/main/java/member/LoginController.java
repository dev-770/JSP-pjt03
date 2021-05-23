package member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.MemberDao;

public class LoginController implements Controller {

	@Override
	public String handlePost(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String login_chk = req.getParameter("login_chk");

		MemberDao mDao = MemberDao.getInstance();
		int loginResult = mDao.login(id, password);
		
		if (loginResult == 1) { // 로그인 성공 시
			req.setAttribute("loginResult", loginResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", id); // 세션 아이디 저장
			
			/* 쿠키 설정 */
			if(login_chk != null) { // 자동 로그인 클릭 시
				Cookie cookie = new Cookie("id", id);
				cookie.setMaxAge(60*60*2); // 2시간
				cookie.setPath("/"); // 최상위 경로 설정
				resp.addCookie(cookie);
			}
			
			return "home.do";
		} else {
			req.setAttribute("loginResult", loginResult);
			return "login.do";
		}
	}

	@Override
	public String handleGet(HttpServletRequest req, HttpServletResponse resp) {
		return "login";
	}


}
