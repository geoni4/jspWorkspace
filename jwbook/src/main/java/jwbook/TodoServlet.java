package jwbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;


@WebServlet("/todolist")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Todo> todoList = new ArrayList<Todo>();
		todoList.add(new Todo(1, "첫번째 할 일", "모닝커피",new Date(), new Date()));
		todoList.add(new Todo(2, "두번째 할 일", "조깅하기",new Date(), new Date()));
		todoList.add(new Todo(3, "세번째 할 일", "출근 준비",new Date(), new Date()));
		todoList.add(new Todo(4, "네번째 할 일", "출근",new Date(), new Date()));
		
		
		request.setAttribute("todolist",todoList);
		request.getSession().setAttribute("todolist", todoList);
		ServletContext application;
		//application.setAttribute("todolist", todoList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("todolist.jsp");
		
		dispatcher.forward(request, response);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
