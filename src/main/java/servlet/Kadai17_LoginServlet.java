package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Kadai16_1_DAO;
import dto.Kadai16_1_DTO;
import util.GenerateHashedPw;

/**
 * Servlet implementation class kadai17_LoginServlet
 */
@WebServlet("/Kadai17_LoginServlet")
public class Kadai17_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai17_LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getParameter("UTF-8");
		
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		
		String salt = Kadai16_1_DAO.getSalt(mail);
		
		if(salt == null) {
			String view = "WEB-INF/view/kadai17_login.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		
		String hashedPw = GenerateHashedPw.getSafetyPassword(pw, salt);
		
		
		Kadai16_1_DTO account = Kadai16_1_DAO.login(mail, hashedPw);
		
		if(account == null) {
			String view = "WEB-INF/view/kadai17_login.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			// ログインに成功したのでセッションに情報を登録
			HttpSession session = request.getSession();
			session.setAttribute("user", account);
			
			String view = "WEB-INF/view/kadai17_menu.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}