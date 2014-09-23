package struts2InAction.actions;

import struts2InAction.services.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -4159835456809010085L;
	
	private transient UserService userService;

	public String list() {
		return "list";
	}

	public String add() {
		userService.add("张三");
		return "add";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
