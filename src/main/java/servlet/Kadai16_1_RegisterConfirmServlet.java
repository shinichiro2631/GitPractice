package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Kadai16_1_DTO;

/**
 * Servlet implementation class Kadai16_1_RegisterConfirmServlet
 */
@WebServlet("/Kadai16_1_RegisterConfirmServlet")
public class Kadai16_1_RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai16_1_RegisterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String number = request.getParameter("number");
			String mail = request.getParameter("email");
			String pw = request.getParameter("pw");
		
			Kadai16_1_DTO account = new Kadai16_1_DTO(-1, name, age, gender, number, mail, null, pw, null);
		
			// セッションスコープのインスタンス取得
			HttpSession session = request.getSession();
		
			// セッションスコープに値の保存
			// 第1引数：キー
			// 第2引数：保存する値
			session.setAttribute("input_data", account);
		
			String view = "WEB-INF/view/kadai16_1_confirm.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
