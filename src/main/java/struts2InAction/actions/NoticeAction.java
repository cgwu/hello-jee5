package struts2InAction.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/common/notice")
public class NoticeAction extends ActionSupport {
	private static final long serialVersionUID = -8104422204024711448L;
	private static final Logger log = LoggerFactory.getLogger( NoticeAction.class );
	
	@Action("list")
	public String list(){
		log.info("公告list()");
		return "list";
	}
	@Action("add")
	public String add(){
		log.info("公告add()");
		return "add";
	}
}
