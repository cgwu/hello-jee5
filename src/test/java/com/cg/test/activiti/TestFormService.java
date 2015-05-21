package com.cg.test.activiti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricFormProperty;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 使用ActivitiRule进行单个流程的测试
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-activiti.xml")
public class TestFormService {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	@Rule
	public ActivitiRule activitiRule;

	@Test
	public void startFormSubmit() {
		ProcessDefinition definition = activitiRule.getRepositoryService()
				.createProcessDefinitionQuery().processDefinitionKey("startFormTest")
				.singleResult();
		assertNotNull(definition);
		FormService formService = activitiRule.getFormService();
		List<FormProperty> formList = formService.getStartFormData(definition.getId())
				.getFormProperties();
		assertEquals(4, formList.size());
		Map<String, String> formProperties = new HashMap<String, String>();
		formProperties.put("name", "Miss Piggy");
		formProperties.put("emailAddress", "piggy@localhost");
		formProperties.put("income", "400");
		formProperties.put("loanAmount", "100");
		formService.submitStartFormData(definition.getId(), formProperties);
		
		List<HistoricDetail> historyVariables = activitiRule.getHistoryService()
				.createHistoricDetailQuery().formProperties().list();
		assertNotNull(historyVariables);
		assertEquals(4, historyVariables.size());
		
		HistoricFormProperty formProperty = (HistoricFormProperty) historyVariables.get(0);
		assertEquals("loanAmount", formProperty.getPropertyId());
		assertEquals("100", formProperty.getPropertyValue());
		
		formProperty = (HistoricFormProperty) historyVariables.get(1);
		assertEquals("income", formProperty.getPropertyId());
		assertEquals("400", formProperty.getPropertyValue());
	}
}
