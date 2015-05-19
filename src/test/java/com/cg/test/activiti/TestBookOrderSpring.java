package com.cg.test.activiti;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-activiti.xml")
public class TestBookOrderSpring {
	private static final Logger log = LoggerFactory
			.getLogger(TestBookOrderSpring.class);

	// @Autowired
	// private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;

	@Test
	public void simpleSpringTest() {
		// repositoryService.createDeployment().addClasspathResource("diagrams/bookorder.bpmn").deploy();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("isbn", 123456L);
		runtimeService.startProcessInstanceByKey("bookorder", variableMap);
		Task task = taskService.createTaskQuery().singleResult();
		assertEquals("Complete order", task.getName());
		taskService.complete(task.getId());
		assertEquals(0, runtimeService.createProcessInstanceQuery().count());

		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("helloworld", variableMap);
		log.info(processInstance.getId());
	}
}
