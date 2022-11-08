package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.StudentService;

public class InfoAction implements ActionCommand {
	StudentService service = new StudentService();

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Student student = service.find(id);
		
		request.setAttribute("student", student);
		
		return "/info.jsp";
	}

}
