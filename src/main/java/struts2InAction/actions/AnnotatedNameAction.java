package struts2InAction.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace("/struts/test")
@Result(location="/struts-test/annotated-name-input.jsp")
@Action("annotatedName")
public class AnnotatedNameAction extends ActionSupport {
	private static final long serialVersionUID = -6650121469573113648L;

}
