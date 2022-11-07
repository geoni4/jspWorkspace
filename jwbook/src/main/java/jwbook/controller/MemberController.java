package jwbook.controller;

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


// .do로 끝나는 모든 url요청은 MemberController를 실행
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, ActionCommand> contList = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("초기화");
		contList = new HashMap<>();
		contList.put("/member/list.do", new ListAction());
		contList.put("/member/info.do", new InfoAction());
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("uri: "+uri);
		String conPath = request.getContextPath();
		System.out.println("conPath: " + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command: " + command);
		
		
		ActionCommand actionCommand = contList.get(command);
		System.out.println(actionCommand);
		
		String view= actionCommand.action(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
		
	}

}
