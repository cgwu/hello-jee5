package struts2InAction.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/test")
@Action("plainText")
@Result(location = "/jsp/plain-text.jsp", type = "plainText",params={"charset","utf-8"})
public class PlainTextAction extends ActionSupport {
	private static final long serialVersionUID = -3173858758896359567L;

}
