package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		/* '/' 후 마지막 URI 추출 */
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		Controller ctrl = handlerMapping.getController(path);
		
		String viewName = ctrl.handleGet(req, resp);
		
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, resp);
		} else {
			view = viewName;
			resp.sendRedirect(view);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		/* '/' 후 마지막 URI 추출 */
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		Controller ctrl = handlerMapping.getController(path);
		
		String viewName = ctrl.handlePost(req, resp);
		
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
			RequestDispatcher rd = req.getRequestDispatcher(view);
			rd.forward(req, resp);
		} else {
			view = viewName;
			resp.sendRedirect(view);
		}
	}
	
}
