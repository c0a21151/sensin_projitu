package pnw.ex05;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

//Point: 学籍番号と氏名を書いてください．
/**
 * 学籍番号: C0A21037
 * 氏名: 川端ももの
 */

/**
 * Point: web.xmlへ記述せずに，pnw内にて，/ex05/KadaiLoginServlet
 * へとマッピングされるように，アノテーションを↓に書いてください．
 **/
@WebServlet("/ex05/KadaiLoginServlet")
public class KadaiLoginServlet extends HttpServlet {

	/**
	 * 正しいログインユーザ名
	 */
	private static final String USER = "pnw";
	/**
	 * 正しいログインパスワード
	 */
	private static final String PASSWORD = "test";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KadaiLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HTTP応答のエンコード設定
		response.setContentType("text/html; charset=UTF-8");

		String user_id = request.getParameter("user");

		String password = request.getParameter("pass");

		String forwardURL = "";
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

		/**
		 * POint: user_idとpasswordが，ともに上記のUSERとPASSWORDに等しいときのみ，
		 * ログイン成功とするように条件分岐を書いてください．
		 * static変数の場合は，クラス名.static変数名 として使うことが出来ます．
		 * また，文字列どうしが同じかどうかは，文字列1.equals(文字列2)という書式です．
		 */
		if (user_id.equals(KadaiLoginServlet.USER) && password.equals(KadaiLoginServlet.PASSWORD)) {
			// ログイン成功の場合の処理
			// Point: 転送先の変数に，pnw内のex05にあるkadaisuccess.jspとしてください．
			forwardURL = "/ex05/kadaisuccess.jsp";
			map.put("msg", "おめでとう．ログイン成功しました");
		} else {
			// ログイン失敗の場合の処理
			// Point: 転送先の変数に，pnw内のex05にあるkadaifailure.jspとしてください．
			forwardURL = "pnw/ex05/kadaifailure.jsp";
			map.put("msg", "だめじゃん，何やってんの？またログイン失敗しちゃったじゃん．");
		}
		// Point: mapを，"map"というkeyでrequestにセットしてください．
		request.setAttribute("map", map);
		// 外部ファイルに転送する準備
		// Point: forwardURLで設定した場所へ転送させるようにしてください(2行のコードで）
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardURL);
		// 外部ファイルに表示処理を任せる
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
