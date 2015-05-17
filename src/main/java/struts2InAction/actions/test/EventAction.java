package struts2InAction.actions.test;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.services.EventService;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/test/event")
public class EventAction extends ActionSupport {
	private static final long serialVersionUID = 7192983207574861511L;

	private EventService eventService;

	private Event model;
	private String msg;
	private boolean post;

	@Action("add")
	public String add() {
		if (isPost()) {
			eventService.addOne(model);
			msg = "已提交了!@@@$$$";
		}
		return "add";
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Event getModel() {
		return model;
	}

	public void setModel(Event model) {
		this.model = model;
	}

	public boolean isPost() {
		return post;
	}

	public void setPost(boolean post) {
		this.post = post;
	}
}
