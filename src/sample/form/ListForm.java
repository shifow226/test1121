package sample.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import sample.model.ListModel2;


public class ListForm extends ActionForm {

	private static int id;
	private String name = null;
	private String email = null;
	private String remarks = null;
	private static List<ListModel2> list_info = null;


	public static List<ListModel2> getList_info() {
		return list_info;
	}

	public static void setList_info(List<ListModel2> list_info) {
		ListForm.list_info = list_info;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		ListForm.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
