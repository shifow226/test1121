package sample.form;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import sample.model.CompleteModel;


public class DeleteForm extends ActionForm {
    private static final long serialVersionUID = 1L;

	private int id;
	private List<CompleteModel> delete_info = null;

    public DeleteForm() {
    }

	public List<CompleteModel> getList_info() {
		return delete_info;
	}

	public void setDelete_info(List<CompleteModel> delete_info) {
		this.delete_info = delete_info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
