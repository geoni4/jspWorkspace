package jwbook.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jwbook.model.Product;
import jwbook.service.ProductService;

@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductService service;
	
	//Servlet이 초기화될 때 서비스 객체가 주입 됨.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("초기화....");
		super.init(config);
		service = new ProductService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view="";
		
		if(action == null) {
			view="/pcontrol?action=list";
			getServletContext().getRequestDispatcher(view)
								.forward(request, response);
			
		} else {
			switch(action) {
			case "list": view = list(request, response); break;
			case "info": view = info(request, response); break;
			}
			getServletContext().getRequestDispatcher(view)
			.forward(request, response);
		}
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		//service의 find(id)메소드로 리스트를 추출해 request에 담아 보내기
		request.setAttribute("p", service.find(request.getParameter("id")));
		return "/productInfo.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		//service의 findAll()메소드로 리스트를 추출해 request에 담아 보내기
		request.setAttribute("products",  service.findAll());
		return "/productList.jsp";
	}
	
}
