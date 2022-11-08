package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import model.Student;
import service.StudentService;

public class InsertAction implements ActionCommand {
	StudentService service = new StudentService();

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		Student s = new Student();
//		s.setUsername(request.getParameter("username"));
//		s.setUniv(request.getParameter("univ"));
//		s.setBirth(Date.valueOf(request.getParameter("birth")));
//		s.setEmail(request.getParameter("email"));
		
		try {
			BeanUtils.populate(s,  request.getParameterMap());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		service.insertStudent(s);
		
//		try {
//			response.sendRedirect("/student/list.do");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "redirect:/student/list.do";
	}

}
