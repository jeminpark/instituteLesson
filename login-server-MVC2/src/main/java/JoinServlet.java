

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDao;

/**
 * Servlet implementation class JoinServlet
 */
//@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
    	
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8" );
	
		response.getWriter().append("Served at: ").append(request.getContextPath() + "<br />");
	
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//response.getWriter().append("id: ").append(id+ "<br />");
		//response.getWriter().append("pw: ").append(pw+ "<br />");
		
		UserDao dao = UserDao.getInstance();
		boolean check = dao.checkLogin(id, pw);
		
		String url = "";
		if(check) {
			url = "main.jsp";
		}
		else {
			url = "index.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}

}
