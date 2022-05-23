

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TopMenuServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		
		//ログイン画面からユーザIDとパスワードを取得する
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//Daoのインスタンス化
		Dao dao = new Dao();
		
		//セッションの取得
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp?err=000");;
		
		if(dao.getName(id, pass) != null) {
			//セッション(UserName)に名前を格納する
			session.setAttribute("UserName", dao.getName(id, pass));
			
			//トップメニュー画面へ
			rd = request.getRequestDispatcher("/jsp/topMenu.jsp");
		} else {
			//エラー1を持ってログイン画面へ
			rd = request.getRequestDispatcher("/jsp/login.jsp?err=1");
		}
		rd.forward(request, response);
	}
	
}
