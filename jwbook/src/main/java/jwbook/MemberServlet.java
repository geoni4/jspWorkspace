package jwbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jwbook.model.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet(description = "memberServlet", urlPatterns = { "/memberlist" })
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> mList = new ArrayList<Member>();
		
		mList.add(new Member("hong", "hong@naver.com"));
		mList.add(new Member("kim", "kim@naver.com"));
		mList.add(new Member("kang", "kang@naver.com"));
		mList.add(new Member("wang", "wang@daum.net"));
		mList.add(new Member("iljimae", "iljimae@naver.com"));
		
		for(Member m: mList) {
			System.out.println(m);
		}
		
		//웹 출력
		PrintWriter out = response.getWriter();
		out.append("<HTML><body>");
		for(Member m: mList) {
			out.append(m.getName()+", "+m.getEmail()+"<br/>");
		}
		out.append("</body></html>");

		
		
		//forward로 이동 전에 request 객체에 전달할 객체를 속성으로 저장
		request.setAttribute("mlist", mList);
		
		//jsp페이지에 넘겨야함
		//1. 이동(forward)할 경로 지정
		RequestDispatcher dispatcher = request.getRequestDispatcher("members.jsp");
		
		//2. request와 response를 넘김
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
