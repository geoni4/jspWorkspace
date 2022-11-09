package jwbook.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import jwbook.model.Product;
import jwbook.model.ProductDAO;
import jwbook.service.ProductServiceMybatis;
import mybatis.MyBatisConnectionFactory;

@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	ProductService service;
	ProductServiceMybatis service;
	
	//Servlet이 초기화될 때 서비스 객체가 주입 됨.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("초기화....");
		super.init(config);
		service = new ProductServiceMybatis();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
			case "insert": insert(request, response);
					view="/pcontrol?action=list";
					break;
			case "updateForm": updateForm(request,response);
					view="/productUpdateForm.jsp";
					break;
			case "update": update(request, response);
					view="/pcontrol?action=list";
					break;
			case "delete": delete(request, response);
					view="/pcontrol?action=list";
					break;
			}
			request.getRequestDispatcher(view)
			.forward(request, response);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			//String id = service.find(request.getParameter("id")).getId();
			String id = request.getParameter("id");
	        // 입력값을 Product 객체로 매핑
			service.delete(id);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			Product product = new Product();
	        // 입력값을 Product 객체로 매핑
			BeanUtils.populate(product, request.getParameterMap());
	        // 이미지 파일 이름을 News 객체에도 저장
	        
			service.update(product);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void updateForm(HttpServletRequest request, HttpServletResponse response) {
		Product product = service.find(request.getParameter("id"));
		request.setAttribute("p", product);
	}

	private String insert(HttpServletRequest request, HttpServletResponse response) {
		try {
			Product product = new Product();
	        
	        // 입력값을 Product 객체로 매핑
			BeanUtils.populate(product, request.getParameterMap());
	        // 이미지 파일 이름을 News 객체에도 저장
	        
			service.insert(product);
		} catch(Exception e) {
			e.printStackTrace();
			return list(request, response);
		}
		return "/pcontrol?action=insert";
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
