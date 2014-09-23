package struts2InAction.services;

public class UserService {
	
	public void add(String name) {
		System.out.println("增加用户:" + name);
	}

	public void delete(String name) {
		System.out.println("删除用户:" + name);
	}

	public void list() {
		System.out.println("列出用户");
	}
}
