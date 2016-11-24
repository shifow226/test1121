package sample.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import sample.model.ListModel2;


public class UserDao {

	// SQLコマンドを作成(データ登録)
	private static final String REGISTERSQL = "INSERT INTO user_list(ID, NAME, EMAIL, REMARKS) VALUES(?,?,?,?)";

	// SQLコマンドを作成(一覧表示)
	private static final String LISTSQL = "SELECT id,name,email,remarks FROM user_list";

	// SQLコマンドを作成(データ更新)
	private static final String UPDATESQL = "UPDATE form SET title = ? WHERE id = ?";

	// SQLコマンドを作成(データ削除)
	private static final String DELETESQL = "DELETE FROM user_list WHERE id = ?";



    	// 変数初期化
        DataSource ds = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String registerSql = null;
        String listSql = null;
        String deleteSql = null;

    	public void register(int id, String name, String email, String remarks, HttpServletRequest request) throws Exception {

            // コンテキスト初期化
        	Context ctx = new InitialContext();

        	// データソースのlookup
        	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");

        	// コネクションオブジェクト定義
        	con = ds.getConnection();

        	// ステートメントの定義
        	stmt = con.createStatement();

    		try {

            	// 問い合わせを実行してリザルトセットを取得
            	rs = stmt.executeQuery(listSql);

            	// データベースから取得した値をモデルに設定
            	List<ListModel2> list = new ArrayList<ListModel2>();
            	while(rs.next()) {
            		ListModel2 listform2 = new ListModel2();
            		listform2.setId(rs.getInt("id"));
            		listform2.setName(rs.getString("name"));
            		list.add(listform2);
            	}

            	// リクエストにListFormInfoを設定（jsp側で使用）
            	request.setAttribute("ListFormInfo", list);

            } catch (Exception e) {
                throw e;
            } finally {
                con.close();
            }



    }
}
