package sample.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.form.UpdateForm;
import sample.model.CompleteModel;

public class userUpdateAction extends Action {

    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        UpdateForm updateForm = (UpdateForm) form;


//        UserModel userModel = (UserModel) model;

        // データベースへの登録処理
        DataSource ds = null;
        Connection con = null;
        PreparedStatement ps = null;

        //SQLコマンドを作成
        String strSql = "UPDATE user_list SET name = ? email = ? remarks = ?  WHERE id = ?";

        try {

        	//コンテキスト初期化
        	Context ctx = new InitialContext();

        	//データソースのlookup
        	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");

        	//コネクションオブジェクト定義
        	con = ds.getConnection();

        	//SQLコマンドを作成
        	ps = con.prepareStatement(strSql);
        	ps.setString(1, updateForm.getName());
        	ps.setInt(2, updateForm.getId());
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

        request.getRequestDispatcher("/complete.jsp").forward(request, response);
        return mapping.findForward("success");
    }

}

