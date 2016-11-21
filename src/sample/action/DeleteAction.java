package sample.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//import org.apache.catalina.Context;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.form.DeleteForm;
import sample.model.CompleteModel;


public class DeleteAction extends Action {

    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception
    {
        DeleteForm deleteForm = (DeleteForm) form;

        // データベースへの登録処理
        DataSource ds = null;
        Connection con = null;
        PreparedStatement ps = null;

        int id = deleteForm.getId();
        String strSql = "DELETE FROM form WHERE id = ?";

        try {
        	//コンテキスト初期化
        	Context ctx = new InitialContext();

        	//データソースのlookup
        	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");

        	//コネクションオブジェクト定義
        	con = ds.getConnection();

        	//ステートメントの定義
        	//Statement stmt = con.createStatement();

        	//SQLコマンドを作成
        	//問い合わせを実行してリザルトセットを取得
        	// int num = stmt.executeUpdate("DELETE FROM form where id = " + String.valueOf(deleteForm.getId()));

        	ps = con.prepareStatement(strSql);
        	ps.setInt(1, id);
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

        request.getRequestDispatcher("/complete.jsp").forward(request, response);
        return mapping.findForward("success");
    }
}
