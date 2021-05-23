package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.MemberDao;
import dto.MemberDto;

public class JoinController implements Controller {

	@Override
	public String handlePost(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String password = req.getParameter("password1");
		String name = req.getParameter("name");
		String nickname = req.getParameter("nickname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		
		MemberDao mDao = MemberDao.getInstance();
		MemberDto mDto = new MemberDto();
		mDto.setId(id);
		mDto.setPassword(password);
		mDto.setName(name);
		mDto.setNickname(nickname);
		mDto.setEmail(email);
		mDto.setPhone(phone);
		mDto.setZip(zip);
		mDto.setAddr1(addr1);
		mDto.setAddr2(addr2);

		int joinResult = mDao.join(mDto);
		
		if(joinResult == 1) {
			req.setAttribute("joinResult", joinResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", id);
			return "home.do";
		} else {
			req.setAttribute("joinResult", 0);
			return "join.do";
		}
	}

	@Override
	public String handleGet(HttpServletRequest req, HttpServletResponse resp) {
		return "member_sign";
	}
}
