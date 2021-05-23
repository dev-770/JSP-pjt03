package notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import dao.NoticeDao;
import dto.NoticeDto;

public class Update_noticeController implements Controller {

	@Override
	public String handlePost(HttpServletRequest req, HttpServletResponse resp) {
		int idx = Integer.parseInt(req.getParameter("idx"));
		
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
		
		nDto.setIdx(idx);
		nDto.setSubject(subject);
		nDto.setFilename(filename);
		nDto.setContent(content);

		nDao.update(nDto);
		return "notice.do";
	}

	@Override
	public String handleGet(HttpServletRequest req, HttpServletResponse resp) {
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeDto nDto = new NoticeDto();
		nDto = nDao.selectById(idx);
		
		req.setAttribute("update", nDto);
		return "update_notice";
		
	}

}
