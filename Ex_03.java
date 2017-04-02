package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex_03
 */
@WebServlet("/Ex_03")
public class Ex_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex_03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("Text/html;charset=euc-kr");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		PrintWriter writer=response.getWriter();
		
		writer.println("아이디 : "+id);
		writer.println("비밀번호 : "+pw);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter writer=response.getWriter();
		String[] hobby=request.getParameterValues("hobby");
		
		writer.println("<html><head></head><body>");
		writer.println("회원정보가 저장되었습니다.<br/>");
		for(int i=0;i<hobby.length;i++){
			writer.println(hobby[i]+" ");
		}
		writer.println("<br/>");
	}

}
