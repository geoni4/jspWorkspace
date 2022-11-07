package jwbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jwbook.model.Member;
import jwbook.service.MemberService;

public class InfoAction implements ActionCommand {
	MemberService service = new MemberService();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) {
		
		//프론트 콘트롤러로부터 넘어온 매개변수 "id"를 추출해		
		String id = request.getParameter("id");
		
		//MemberService에 있는 find메소드의 매개변수로 넣고
		Member member = service.find(id);
		
		// mem속성으로 저장하고 이동할 페이지를 프론트 컨트롤러로 리턴함
		request.setAttribute("mem", member);
		return "/memberInfo.jsp";
	}

}
