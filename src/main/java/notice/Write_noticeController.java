package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import dao.NoticeDao;
import dto.NoticeDto;

public class Write_noticeController implements Controller{

	@Override
	public String handlePost(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		String sessionID = (String) session.getAttribute("sessionID");
		
		String savePath = req.getRealPath("/upload");
		int size = 1024 * 1024 * 10; // 10MB

		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(req, savePath, size, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String subject = multi.getParameter("subject");
		String filename = multi.getFilesystemName("filename");
		String content = multi.getParameter("content");
		
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeDto nDto = new NoticeDto();
		nDto.setIdx(nDao.nextval() + 1);
		nDto.setSubject(subject);
		nDto.setFilename(filename);
		nDto.setContent(content);
		nDto.setParent(nDao.nextval() + 1);
		nDto.setId(sessionID);
		
		int wResult = nDao.write(nDto);
		return "notice.do";
	}

	@Override
	public String handleGet(HttpServletRequest req, HttpServletResponse resp) {
		return "write_notice";
	}

	
}
