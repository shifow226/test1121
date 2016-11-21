package sample.form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UpdateForm extends ActionForm {

	private int id;
	private String title = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
