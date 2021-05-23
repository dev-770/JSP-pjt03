package controller;

import java.util.HashMap;
import java.util.Map;

import action.CompanyController;
import action.HomeController;
import action.ServiceController;
import action.ServiceController1;
import action.ServiceController5;
import member.JoinController;
import member.LoginController;
import member.LogoutController;
import notice.Delete_noticeController;
import notice.NoticeController;
import notice.Search_noticeController;
import notice.Update_noticeController;
import notice.View_noticeController;
import notice.Write_noticeController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping () {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/join.do", new JoinController());
		mappings.put("/home.do", new HomeController());
		mappings.put("/notice.do", new NoticeController());
		mappings.put("/write_notice.do", new Write_noticeController());
		mappings.put("/update_notice.do", new Update_noticeController());
		mappings.put("/delete_notice.do", new Delete_noticeController());
		mappings.put("/view_notice.do", new View_noticeController());
		mappings.put("/search_notice.do", new Search_noticeController());
		mappings.put("/company.do", new CompanyController());
		mappings.put("/service.do", new ServiceController());
		mappings.put("/service1.do", new ServiceController1());
		mappings.put("/service5.do", new ServiceController5());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}

}
