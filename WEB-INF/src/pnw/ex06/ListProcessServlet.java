package pnw.ex06;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pnw.common.PnwDB;

import javax.servlet.RequestDispatcher;

@WebServlet("/ex06/ListProcessServlet")
public class ListProcessServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProcessServlet() {
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

        ResultSet rs;
        String forwardURL = null;
        // ボタンの値を取得する．
        String btn_val = request.getParameter("btn");

        try {
            /** DB接続に関する共通部 START **/
            // DB接続してStatementを取得する．
            PnwDB db = new PnwDB("testdb");
            String sql = null;
            // 入力値を取得しておく．
            int in_id = 0;
            if (!request.getParameter("id").equals("")) {
                in_id = Integer.valueOf(request.getParameter("id")).intValue();
            }

            String userid = request.getParameter("userid");
            String password = request.getParameter("pass");
            PreparedStatement stmt = null;
            switch (btn_val) {
                case "追加":
                    sql = "INSERT INTO userinfo (userid,password) VALUES(?,?)";
                    stmt = db.getStmt(sql);
                    stmt.setString(1, userid);
                    stmt.setString(2, password);
                    int ret = stmt.executeUpdate();

                    break;

                case "更新":
                    sql = "UPDATE userinfo SET userid=?,password=? WHERE id=?";
                    stmt = db.getStmt(sql);
                    stmt.setString(1, userid);
                    stmt.setString(2, password);
                    stmt.setInt(3, in_id);
                    int ret2 = stmt.executeUpdate();
                    break;

                case "削除":
                    sql = "DELETE FROM userinfo WHERE id=?";
                    stmt = db.getStmt(sql);
                    stmt.setInt(1, in_id);
                    int ret3 = stmt.executeUpdate();
                    break;

            }
            // 個別の処理が終わったら，再度，DBから一覧を取得する．
            // SQL文の作成(プレースホルダーを使うのがわかりやすい)
            sql = "SELECT * FROM userinfo";
            stmt = db.getStmt(sql);
            /** DB接続に関する共通部 END **/

            // 実行結果取得
            rs = stmt.executeQuery();
            // データがなくなるまで(rs.next()がfalseになるまで)繰り返す
            int cnt = 0;
            ArrayList<UserInfoBean> infoArray = new ArrayList<UserInfoBean>();
            while (rs.next()) {
                // カラムの値を取得する．
                int id = rs.getInt("id");
                String uid = rs.getString("userid");
                String pass = rs.getString("password");
                // beanを生成
                UserInfoBean bean = new UserInfoBean(uid, pass);
                bean.setID(id);
                // Listへbeanを追加する．
                infoArray.add(bean);
                // 見つかった
                cnt++;
            }
            // リクエストへセットする．
            request.setAttribute("userlist", infoArray);
            forwardURL = "/ex06/list.jsp";

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 外部ファイルに転送する準備
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
