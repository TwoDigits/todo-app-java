package io.twodigits.todo.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.twodigits.todo.dao.TaskDao;
import io.twodigits.todo.dao.TaskDaoImpl;
import io.twodigits.todo.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;

/**
 * Entrypoints for API Gateway
 */

/**
 * Never Code Alone - AWS Lambda with Java
 *
 * Tasks:
 *
 * 1.) Implement functionality to create tasks
 * 2.) Implement functionality to get a task by "id"
 * 3.) Implement functionality to update a task
 * 4.) Implement functionality to delete task
 *
 * Further instructions and hints can be found within the code
 *
 *
 */

public class TaskRequestHandler {

	private TaskDao dao;

	public void setTaskDao(TaskDao dao) {
		this.dao = dao;
	}

	private TaskDao getTaskDao() {
		if(this.dao == null) {
			this.dao = new TaskDaoImpl();
		}
		return this.dao;
	}

	public APIGatewayProxyResponseEvent listTasks(APIGatewayProxyRequestEvent request, Context context) {
		List<Task> tasks = this.getTaskDao().listTasks();

		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(tasks);

			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type", "application/json");
			return new APIGatewayProxyResponseEvent().withStatusCode(200).withHeaders(headers).withBody(jsonInString);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
			return new APIGatewayProxyResponseEvent().withStatusCode(500);
		}
	}

	/**
	 * Task 1) Create Task
	 */
	public APIGatewayProxyResponseEvent createTask(APIGatewayProxyRequestEvent request, Context context) {

		/**
		 * TODO:
		 * - Get json body request and map to Task object
		 * - Save task via DAO
		 * - Return proper status code for CREATED and INTERNAL SERVER ERROR for errors
		 */

		return new APIGatewayProxyResponseEvent().withStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
	}

	/**
	 * Task 2) Get Task
	 */
	public APIGatewayProxyResponseEvent getTask(APIGatewayProxyRequestEvent request, Context context) {

		/**
		 * TODO:
		 * - Get Task "id" from request path parameter
		 * - Try to get corresponding Task object for "id"
		 * - Map Task object to JSON String and return with proper header (content-type: application/json) and status code
		 * - Catch errors and return proper status code (NOT FOUND, INTERNAL SERVER ERROR)
		 */

		return new APIGatewayProxyResponseEvent().withStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
	}

	/**
	 * Task 3) Update Task
	 */
	public APIGatewayProxyResponseEvent updateTask(APIGatewayProxyRequestEvent request, Context context) {

		/**
		 * TODO:
		 * - Get json body from request and map to Task object
		 * - Save task via DAO
		 * - Return proper status code OK and INTERNAL SERVER ERROR for errors
		 */

		return new APIGatewayProxyResponseEvent().withStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
	}

	/**
	 * Task 4) Delete Task
	 */
	public APIGatewayProxyResponseEvent deleteTask(APIGatewayProxyRequestEvent request, Context context) {

		/**
		 * TODO:
		 * - Get Task "id" from request path parameter
		 * - Delete Task via DAO
		 * - Return status code OK
		 */

		return new APIGatewayProxyResponseEvent().withStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
	}

}
