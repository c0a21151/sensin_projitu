package pnw.ex05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class
 */
@WebServlet("/ex05/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
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
		// response.setContentType("text/html; charset=UTF-8");
		// response.setCharacterEncoding("UTF-8");

		// リクエストからの値取得
		LinkedHashMap<String, Object> valMap = new LinkedHashMap<String, Object>();

		// テキスト
		String text = request.getParameter("input1");
		valMap.put("input1", text);

		// password
		String password = request.getParameter("input2");
		valMap.put("input2", password);

		// チェックボックス(複数指定可能なもの)
		// PHPとは違い，name属性をそのまま指定する．
		// PHPだと，$_GET["fruit"]で配列がやってくる．
		String[] check_fruit = request.getParameterValues("fruit[]");
		ArrayList<String> fList = new ArrayList<String>();

		for (int i = 0; i < check_fruit.length; i++) {
			fList.add(check_fruit[i]);
		}
		valMap.put("fruit", fList);

		// ラジオボタン
		String grade = request.getParameter("grade");
		valMap.put("grade", grade);

		// プルダウン
		String country = request.getParameter("country");
		valMap.put("country", country);

		// テキストエリア
		String summary = request.getParameter("summary");
		valMap.put("summary", summary);

		// Map自体を，requestのAttributeへセットする．
		request.setAttribute("map", valMap);

		// 外部ファイルに転送する準備
		// ファイルの場所は，/webapps/pnw/から見た場所
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ex05/formResult.jsp");

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
