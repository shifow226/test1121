package sample.form;


import java.util.List;

import org.apache.struts.action.ActionForm;

import sample.model.ListModel2;


public class ListForm extends ActionForm {

	private static int id;
	private static String title = null;
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

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		ListForm.title = title;
	}
}
