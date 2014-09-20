package struts2InAction.actions.test;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/test/product")
@ParentPackage("default")
public class ProductAction extends ActionSupport {
	private static final long serialVersionUID = -482341107997883758L;

	@Action("add")
	public String add() {
		System.out.println("product add");
		return "add";
	}
	@Action("list")
	public String list() {
		System.out.println("product list");
		return "list";
	}

}
