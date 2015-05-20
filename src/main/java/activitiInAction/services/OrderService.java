package activitiInAction.services;

import org.activiti.engine.delegate.DelegateExecution;

/*
 * 验证Task执行
 */
public class OrderService {
	public void validate(DelegateExecution execution) {
		System.out.println("validateing order for isbn:" + execution.getVariable("isbn"));
	}
}
