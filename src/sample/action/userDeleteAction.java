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

import sample.model.UserModel;
import sample.model.CompleteModel;

import sample.dao.UserDao;


public class userDeleteAction extends Action {
	
	public ActionForward execute(
	        ActionMapping mapping,
	        ActionForm form,
	        HttpServletRequest request,
	        HttpServletResponse response) throws Exception
	    {
	
			public void registerUser(int id, String name, String email, String remarks) {
		
			UserDao dao = new UserDao();
		
			dao.register(id, name, email, remarks);
			}
	    }
}