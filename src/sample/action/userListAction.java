package sample.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sample.dao.UserDao;
import sample.model.UserModel;

public class userListAction extends Action {

    public ActionForward execute(

        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

			UserDao dao = new UserDao();
	    	UserModel user = new UserModel();
			dao.list(user, mapping, request, response);

        request.getRequestDispatcher("/UserList.jsp").forward(request, response);
        return mapping.findForward("success");

    }
}
