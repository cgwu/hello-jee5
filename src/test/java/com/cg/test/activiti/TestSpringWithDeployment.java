package com.cg.test.activiti;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
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
public class TestSpringWithDeployment {

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
	@Deployment(resources = { "diagrams/bookorder.bpmn" })
	public void test() {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("isbn", 886L);
		runtimeService.startProcessInstanceByKey("bookorder", variableMap);
		Task task = taskService.createTaskQuery().singleResult();
		assertEquals("Complete order", task.getName());
		taskService.complete(task.getId());
		assertEquals(0, runtimeService.createProcessInstanceQuery().count());
	}

}
