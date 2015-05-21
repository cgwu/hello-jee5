package com.cg.test.activiti;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricVariableUpdate;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import activitiInAction.services.LoanApplication;

/*
 * 使用ActivitiRule进行单个流程的测试
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-activiti.xml")
public class TestLoanRequest {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	@Rule
	public ActivitiRule activitiSpringRule;

	
	/**
	 * The advantage of this deployment strategy is that it’s finer grained. You
	 * can define a specific process definition to be deployed before a test
	 * method is executed, and it will be undeployed afterwards. When you define
	 * the deployment resources as part of the Spring configuration, they will
	 * be available for every test method.
	 */
	@Test
	@Deployment(resources = { "diagrams/loanrequest.bpmn" })
	public void creditCheckTrue() {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Miss Piggy");
		variableMap.put("income", 1001L);
		variableMap.put("loanAmount", 101L);
		variableMap.put("emailAddress", "miss.piggy@localhost");
		
		runtimeService.startProcessInstanceByKey("loanrequest", variableMap);
		
		List<HistoricDetail> historyVariables = activitiSpringRule.getHistoryService()
				.createHistoricDetailQuery()
				.variableUpdates()
				.orderByVariableName()
				.asc()
				.list();
		assertNotNull(historyVariables);
		assertEquals(6, historyVariables.size());
		HistoricVariableUpdate loanAppUpdate = (HistoricVariableUpdate) historyVariables.get(4);
		assertEquals("loanApplication",loanAppUpdate.getVariableName());
		LoanApplication la = (LoanApplication)loanAppUpdate.getValue();
		assertEquals(true,la.isCreditCheckOk());
		
	}

}
