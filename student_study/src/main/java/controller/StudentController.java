package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, ActionCommand> commandList = null;

	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		commandList = new HashMap<String, ActionCommand>();
		commandList.put("/student/list.do", new ListAction());
		commandList.put("/student/info.do", new InfoAction());
	}




	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		ActionCommand actionCommand = commandList.get(command);
		
//		request.getRequestDispatcher(actionCommand.action(request, response))
//		.forward(request, response);
		
		String view = actionCommand.action(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
	}
	
	
	
}
