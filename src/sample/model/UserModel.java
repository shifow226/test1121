package sample.model;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UserModel extends ActionForm {

	private int Id;
	private String Name = null;
	private String Email = null;
	private String Remarks = null;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        try {
            request.setCharacterEncoding("utf-8");
        } catch(UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }

}
