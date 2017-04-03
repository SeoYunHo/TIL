package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex_04
 */
@WebServlet(urlPatterns={"/Ex_04"}, initParams={@WebInitParam(name="id",value="asdf"),@WebInitParam(name="pw", value="1234")}	)
public class Ex_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex_04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=getInitParameter("id");
		String pw=getInitParameter("pw");
		
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter writer=response.getWriter();
		writer.println("<html><head></head><body>");
		if(id.equals(request.getParameter("id"))&&pw.equals(request.getParameter("pw"))){
			writer.println("�α����� �Ϸ�Ǿ����ϴ�.<br/>");
		}else{
			writer.println("���̵� �Ǵ� ��й�ȣ�� �߸��Է��߽��ϴ�.");
		}
		writer.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
