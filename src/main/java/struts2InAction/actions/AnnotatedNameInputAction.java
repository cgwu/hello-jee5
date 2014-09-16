package struts2InAction.actions;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ParentPackage("struts-default")
@Namespace("/struts/test")
@Results({ 
	@Result(name = "SUCCESS", location = "/struts-test/annotated-name-success.jsp"),
	@Result(name = "INPUT", location = "/struts-test/annotated-name-input.jsp") 
})
public class AnnotatedNameInputAction {
	private static final Logger log = LoggerFactory.getLogger( AnnotatedNameInputAction.class );
	
	private static final String GREETING = "(使用注解)你好:";

	private String name;
	private BigDecimal score;
	private String customGreeting;

	@Action(value="annotatedNameInput")
	public String execute() {
		log.info("执行:{}", this);
		if (StringUtils.isEmpty(name) || "123".equals(name)) {
			return "INPUT";
		}
		setCustomGreeting(GREETING + getName() + "; 分数:" + getScore());
		return "SUCCESS";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomGreeting() {
		return customGreeting;
	}

	public void setCustomGreeting(String customGreeting) {
		this.customGreeting = customGreeting;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}
}
