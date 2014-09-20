package struts2InAction.actions.test;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/*
 @Namespace("/test")
 @Action("plainText")
 @Result(location = "/jsp/plain-text.jsp", type = "plainText",params={"charset","utf-8"})
 */

@Result(location = "/jsp/test/plain-text.jsp", type = "plainText",params={"charset","utf-8"})

/*
 * 可通过以下URL访问,
 * http://localhost:8080/test/plain-text.htm
 * 这个示例的用意是:
 * 可以通过子包名test默认映射为路径/test
 * PlainTextAction => plain-text.htm
 * */
public class PlainTextAction extends ActionSupport {
	private static final long serialVersionUID = -3173858758896359567L;
	@Override
	public String execute() throws Exception {
		System.out.println("PlainTextAction执行了!!!");
		return SUCCESS;
	}
}
