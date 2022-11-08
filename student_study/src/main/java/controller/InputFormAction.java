package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;

public class InputFormAction implements ActionCommand {
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		return "/input.jsp";
	}

}
