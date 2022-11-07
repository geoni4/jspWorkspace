package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.StudentService;

public class ListAction  implements ActionCommand {
	StudentService service = new StudentService();

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		List<Student> list = service.findAll();
		
		request.setAttribute("list", list);
		return "/list.jsp";
	}

}
