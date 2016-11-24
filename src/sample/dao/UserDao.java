package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sample.form.DeleteForm;
import sample.form.RegisterForm;
import sample.form.UpdateForm;
import sample.model.CompleteModel;
import sample.model.ListModel2;

public class UserDao {

	// SQLコマンドを作成(データ登録)
	private static final String CREATESQL = "INSERT INTO user_list(ID, NAME, EMAIL, REMARKS) VALUES(?,?,?,?)";

	// SQLコマンドを作成(一覧取得)
	private static final String LISTSQL = "SELECT id,name,email,remarks FROM user_list";

	// SQLコマンドを作成(データ更新)
	private static final String UPDATESQL = "UPDATE user_list SET name = ? email = ? remarks = ? WHERE id = ?";

	// SQLコマンドを作成(データ削除)
	private static final String DELETESQL = "DELETE FROM user_list WHERE id = ?";

	// 変数初期化
    DataSource ds = null;
    Connection con = null;
    PreparedStatement ps = null;
    Statement stmt = null;
    ResultSet rs = null;

    // データ登録処理
 	public void create (
 			int id,
 			String name,
 			String email,
 			String remarks,
 			ActionMapping mapping,
 	        ActionForm form,
 	        HttpServletRequest request,
 	        HttpServletResponse response) throws Exception {

 		RegisterForm registerForm = (RegisterForm) form;

 		// コンテキスト初期化
     	Context ctx = new InitialContext();

     	// データソースのlookup
     	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");

     	// コネクションオブジェクト定義
     	con = ds.getConnection();

 		try {

 			//SQLコマンドを作成
        	ps = con.prepareStatement(CREATESQL);
        	ps.setInt(1, registerForm.getId());
        	ps.setString(2, registerForm.getName());
        	ps.setString(3, registerForm.getEmail());
        	ps.setString(4, registerForm.getRemarks());
        	ps.executeUpdate();

        	CompleteModel complete = new CompleteModel();
        	complete.setCompleteTitle("登録完了");
        	complete.setCompleteMessage("登録完了しました");

        	request.setAttribute("CompleteInfo", complete);

         } catch (Exception e) {
             throw e;
         } finally {
             con.close();
         }
 	}

    // 一覧取得処理
 	public void list (
 			int id,
 			String name,
 			String email,
 			String remarks,
 			ActionMapping mapping,
 	        ActionForm form,
 	        HttpServletRequest request,
 	        HttpServletResponse response) throws Exception {

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
        	rs = stmt.executeQuery(LISTSQL);

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

 	// データ更新処理
 	public void update  (
 			int id,
 			String name,
 			String email,
 			String remarks,
 			ActionMapping mapping,
 	        ActionForm form,
 	        HttpServletRequest request,
 	        HttpServletResponse response) throws Exception {

 		UpdateForm updateForm = (UpdateForm) form;

 		// コンテキスト初期化
     	Context ctx = new InitialContext();

     	// データソースのlookup
     	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");

     	// コネクションオブジェクト定義
     	con = ds.getConnection();

     	// ステートメントの定義
//     	stmt = con.createStatement();

        try {

        	// 問い合わせを実行してリザルトセットを取得
//        	rs = stmt.executeQuery(UPDATESQL);

        	// SQLコマンドを作成
        	ps = con.prepareStatement(UPDATESQL);
        	ps.setString(1, updateForm.getName());
        	ps.setString(2, updateForm.getEmail());
        	ps.setString(3, updateForm.getRemarks());
        	ps.setInt(4, updateForm.getId());
        	ps.executeUpdate();

        	CompleteModel complete = new CompleteModel();
        	complete.setCompleteTitle("更新完了");
        	complete.setCompleteMessage("更新完了しました");

        	request.setAttribute("CompleteInfo", complete);

        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
        }
 	}

 	// データ削除処理
 	public void delete  (
 			int id,
 			String name,
 			String email,
 			String remarks,
 			ActionMapping mapping,
 	        ActionForm form,
 	        HttpServletRequest request,
 	        HttpServletResponse response) throws Exception {

 		DeleteForm deleteForm = (DeleteForm) form;

 		// コンテキスト初期化
    	Context ctx = new InitialContext();

    	// データソースのlookup
    	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");

    	// コネクションオブジェクト定義
    	con = ds.getConnection();

    	// ステートメントの定義
//    	stmt = con.createStatement();

        try {

        	// 問い合わせを実行してリザルトセットを取得
//        	rs = stmt.executeQuery(DELETESQL);
        	ps = con.prepareStatement(DELETESQL);
        	ps.setInt(1, deleteForm.getId());
        	ps.executeUpdate();

        	CompleteModel complete = new CompleteModel();
        	complete.setCompleteTitle("削除完了");
        	complete.setCompleteMessage("削除完了しました");

        	request.setAttribute("CompleteInfo", complete);

        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
        }
 	}
}
