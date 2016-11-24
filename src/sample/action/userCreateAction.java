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

import sample.dao.UserDao;
import sample.form.RegisterForm;
import sample.model.CompleteModel;

public class userCreateAction extends Action {

    public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        RegisterForm registerForm = (RegisterForm) form;

        // データベースへの登録処理
        DataSource ds = null;
        Connection con = null;
        PreparedStatement ps = null;

        int id = registerForm.getId();

        String strSql = "INSERT INTO user_list(ID, NAME, EMAIL, REMARKS) VALUES(?,?,?,?)";

        try {

        	//コンテキスト初期化
        	Context ctx = new InitialContext();

        	//データソースのlookup
        	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");

        	//コネクションオブジェクト定義
        	con = ds.getConnection();

        	//SQLコマンドを作成
        	ps = con.prepareStatement(strSql);
        	ps.setInt(1, id);
        	ps.setString(2, registerForm.getName());
        	ps.setString(3, registerForm.getEmail());
        	ps.setString(4, registerForm.getRemarks());
        	ps.executeUpdate();

        	CompleteModel complete = new CompleteModel();
        	complete.setCompleteTitle("登録完了");
        	complete.setCompleteMessage("登録完了しました");

        	request.setAttribute("CompleteInfo", complete);




        	UserDao dao = new UserDao();
        	dao.create(id, strSql, strSql, strSql, mapping, form, request, response);

        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
        }

        request.getRequestDispatcher("/complete.jsp").forward(request, response);
        return mapping.findForward("success");
    }
}

