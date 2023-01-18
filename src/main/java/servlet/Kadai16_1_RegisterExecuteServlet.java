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

/**
 * Servlet implementation class Kadai16_1_RegisterExecuteServlet
 */
@WebServlet("/Kadai16_1_RegisterExecuteServlet")
public class Kadai16_1_RegisterExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai16_1_RegisterExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープのインスタンス取得
				HttpSession session = request.getSession();

				// 入力データの取得
				Kadai16_1_DTO account = (Kadai16_1_DTO)session.getAttribute("input_data");
				
				// 登録処理
				int result = Kadai16_1_DAO.registerAccount(account);
				
				String path = "";
				if(result == 1) {
					// 登録に成功したので、sessionのデータを削除
					session.removeAttribute("input_data");
					
					path = "WEB-INF/view/kadai16_1_success.jsp";
				} else {
					// 失敗した場合はパラメータ付きで登録画面に戻す
					path = "WEB-INF/view/kadai16_1_form.jsp?error=1";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// TODO Auto-generated method stub
				doGet(request, response);
			}

		}