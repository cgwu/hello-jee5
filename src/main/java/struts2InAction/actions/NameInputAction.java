package struts2InAction.actions;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class NameInputAction {
	private static final String GREETING = "你好:";

	private String name;
	private BigDecimal score;
	private String customGreeting;

	public String execute() {
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
