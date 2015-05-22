package com.cg.test.activiti;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-activiti.xml")
public class TestSimpleMail {
	private static final Logger log = LoggerFactory
			.getLogger(TestSimpleMail.class);
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	
	@Autowired
	@Rule
	public ActivitiRule activitiSpringRule;

	@Test
	@Deployment(resources = { "diagrams/simpleMail.bpmn20.xml" })
	public void sendMail() {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "张三");
		System.out.println("before start.");
		runtimeService.startProcessInstanceByKey("simpleEmailProcess", variableMap);
		System.out.println("test mail done.");
	}
}
