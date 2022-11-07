package jwbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jwbook.model.Member;
import jwbook.service.MemberService;

public class ListAction implements ActionCommand {
	MemberService service = new MemberService();
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		List<Member> list = service.findAll();
		request.setAttribute("list", list);
		return "/memberList.jsp";
	}
	
}
