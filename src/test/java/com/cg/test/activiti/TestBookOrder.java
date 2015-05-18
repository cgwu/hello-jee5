package com.cg.test.activiti;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class TestBookOrder {

	@Test
	public void test() {
		/*
		 * This creates a new process engine with all the defaults to connect to
		 * a remote h2 database (jdbc:h2:tcp://localhost/activiti) in standalone
		 * mode. Standalone mode means that Activiti will manage the
		 * transactions on the JDBC connections that it creates. One transaction
		 * per service method. For a description of how to write the
		 * configuration files, see the userguide.
		 */
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration().buildProcessEngine();
		
		RuntimeService runtimeService = processEngine.getRuntimeService();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		IdentityService identityService = processEngine.getIdentityService();
		TaskService taskService = processEngine.getTaskService();
		
		repositoryService.createDeployment().addClasspathResource("diagrams/bookorder.bpmn").deploy();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("isbn", "123456");
		identityService.setAuthenticatedUserId("kermit");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("bookorder",
				variableMap);
		assertNotNull(processInstance.getId());
		List<Task> taskList = taskService.createTaskQuery().taskCandidateUser("kermit").list();
		assertEquals(1, taskList.size());
		System.out.println("found task " + taskList.get(0).getName());
		//taskService.complete(taskList.get(0).getId());
	}

}
