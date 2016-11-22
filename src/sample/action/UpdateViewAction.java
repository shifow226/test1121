package sample.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.model.ListModel2;


public class UpdateViewAction extends Action {

	public ActionForward execute(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception
    {
    	// 変数初期化
        DataSource ds = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String strSql = null;

//System.out.println("aaa");
        try {
        	//コンテキスト初期化
        	Context ctx = new InitialContext();

        	//データソースのlookup
        	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");

        	//コネクションオブジェクト定義
        	con = ds.getConnection();

        	//ステートメントの定義
        	stmt = con.createStatement();

        	//SQLコマンドを作成
        	strSql = "SELECT id,name,email,remarks FROM user_list";

        	//問い合わせを実行してリザルトセットを取得
        	rs = stmt.executeQuery(strSql);

        	// データベースから取得した値をモデルに設定
        	List<ListModel2> list = new ArrayList<ListModel2>();
        	while(rs.next()) {
        		ListModel2 listform2 = new ListModel2();
        		listform2.setId(rs.getInt("id"));
        		listform2.setName(rs.getString("name"));
        		listform2.setEmail(rs.getString("email"));
        		listform2.setRemarks(rs.getString("remarks"));
        		list.add(listform2);
        	}

        	// リクエストにListFormInfoを設定（jsp側で使用）
        	request.setAttribute("ListFormInfo", list);

//        	@SuppressWarnings("rawtypes")
//			Map menuPulldown = new TreeMap();
//        	menuPulldown.put("id", rs.getInt("id"));
//        	request.setAttribute("menu.pulldown", menuPulldown);

        	LinkedHashMap<String, String> idMap = new LinkedHashMap<String, String>();
//        	idMap.put("id", "id");
        	for (ListModel2 value: list) {
        		idMap.put(
        				String.valueOf(
        						value.getId()
        					),
        				String.valueOf(
        						value.getId()
        				));
        	}

        	BeanUtils.setProperty(form, "idMap", idMap);


        } catch (Exception e) {
            throw e;
        } finally {
            con.close();
        }

        request.getRequestDispatcher("/update.jsp").forward(request, response);
        return mapping.findForward("success");

    }
}
