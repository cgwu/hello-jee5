package struts2InAction.actions;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -4159835456809010085L;

	public String list() {
		return "list";
	}

	public String add() {
		return "add";
	}
}
