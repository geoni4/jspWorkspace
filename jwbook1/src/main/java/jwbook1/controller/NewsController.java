package jwbook1.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import jwbook1.model.News;
import jwbook1.model.NewsDAO;

@WebServlet("/news.nhn")
@MultipartConfig(maxFileSize = 1024*1024*2, location = "C:/temp/img")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NewsDAO dao;
	private ServletContext ctx;
	
	//웹 리소스 기본 경로 지정
	private final String START_PAGE = "/newsList.jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new NewsDAO();
		ctx = getServletContext();
	}


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		dao = new NewsDAO();
		
		Method m;
		String view = null;
		
		if(action == null) {
			action = "listNews";
		}
		
		try {
			
			// 리플렉션으로 method 이름 받아옴.
			System.out.println(action);
			m = this.getClass().getMethod(action, HttpServletRequest.class);
			
			System.out.println(m.getReturnType());
			//메소드 실행 후 리턴 값 받아옴.
			view = (String)m.invoke(this, request);
			
		} catch(Exception e) {
			e.printStackTrace();
			ctx.log("요청 action 없음");
			request.setAttribute("error", "action 파라미터가 잘못되었습니다.");
			view = START_PAGE;
		}
		
		//post요청 처리 후 리다이렉션
		
		if(view.startsWith("redirect:/")) {
			String rview = view.substring("redirect:/".length());
			response.sendRedirect(rview);
		} else {
			// 지정된 뷰로 포워딩, 포워딩시 컨텍스트 경로는 필요 없음
			System.out.println(view);
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
		
		
	}
	
	public String addNews(HttpServletRequest request) {
		News n = new News();
		try {
	        Part part = request.getPart("file");
	        String fileName = getFilename(part);
	        if(fileName != null && !fileName.isEmpty()){
	            part.write(fileName);
	        }
	        // 입력값을 News 객체로 매핑
			BeanUtils.populate(n, request.getParameterMap());
			
	        // 이미지 파일 이름을 News 객체에도 저장
	        n.setImg("/img/"+fileName);

			dao.addNews(n);
		} catch(Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 추가 과정에서 문제 발생");
			request.setAttribute("error", "뉴스가 정상적으로 등록되지 않았습니다.");
			return listNews(request);
		}
		
		
		return "redirect:/news.nhn?action=listNews";
	}

	public String deleteNews(HttpServletRequest request) {
		try {
		int aid = Integer.parseInt(request.getParameter("aid"));
		News news = dao.getNews(aid);
		dao.delNews(aid);
		
		String realfileName = "c:/temp"+news.getImg();
		File file = new File(realfileName);
		if(file.exists()) {
			file.delete();
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 삭제 과정에서 문제 발생");
			request.setAttribute("error", "뉴스를 정상적으로 삭제하지 못했습니다.");
			return listNews(request);
		}
		
		return "redirect:/news.nhn?action=listNews";
	}
	
	public String listNews(HttpServletRequest request) {
		try {
			List<News> newsList = dao.getAll();
			
			request.setAttribute("newslist", newsList);
		} catch(Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 로드 과정에서 문제 발생");
			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다.");
			return listNews(request);
		}
		
		return "/newsList.jsp";
	}
	
	public String getNews(HttpServletRequest request) {
		try {
			int aid = Integer.parseInt(request.getParameter("aid"));
			News news = dao.getNews(aid);
			
			request.setAttribute("news", news);
			
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 로드 과정에서 문제 발생");
			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다.");
			return listNews(request);
		}
		return "/newsView.jsp";
	}
	
	private String getFilename(Part part) {
		String fileName = null;
		String header = part.getHeader("content-disposition");
		System.out.println("Header => "+header);
		
		int start = header.indexOf("filename=");
		fileName = header.substring(start+10, header.length()-1);
		ctx.log("파일명:" +fileName);
		return fileName;
	}
	
}
