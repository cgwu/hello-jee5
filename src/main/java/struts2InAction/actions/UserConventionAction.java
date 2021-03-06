package struts2InAction.actions;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import struts2InAction.services.UserService;

import com.cg.web.filters.LogingFilter;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/system/convention")
public class UserConventionAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -4159835456809010085L;

	private static final Logger log = LoggerFactory.getLogger(UserConventionAction.class);

	private transient UserService userService;

	private String name;

	private Map<String, Object> session;

	@Action("list")
	public String list() {
		log.info("调用list()");
		session.put("startTime", new Date());
		userService.list();
		return "list";
	}

	@Action("add")
	public String add() {
		// log.info("调用add()");
		// userService.add(name);
		String hi = userService.sayHi(name);
		log.info("方法调用结果:{}", hi);
		return "add";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		session = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
