package io.twodigits.todo.dao;

import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import io.twodigits.todo.model.Task;

public class TaskDaoImpl implements TaskDao {

	private AmazonDynamoDB client;
	private DynamoDBMapper mapper;

	public TaskDaoImpl() {
		this.client = AmazonDynamoDBClientBuilder.standard().build();
		this.mapper = new DynamoDBMapper(this.client);
	}

	public List<Task> listTasks() {
		return this.mapper.scan(Task.class, new DynamoDBScanExpression());
	}

	/**
	 * Task 2) Get Task
	 */
	public Task getTask(String id) {
		/**
		 * TODO:
		 * - Use DynamoDB mapper to get a Task by its "id"
		 */

		return null;
	}

	/**
	 * Task 1 & 3) Create/Update Task
	 */
	public void saveTask(Task task) {

		/**
		 * TODO:
		 * - Check if "id" is present, otherwise create an unique "id", e.g. using UUID
		 * - Create/save a Task object in database using DynamoDB mapper
		 */
	}

	/**
	 * Task 4) Delete Task
	 */
	public void deleteTask(String id) {
		/**
		 * TODO:
		 * - Check if Task for id exists and delete it using DynamoDB mapper
		 */
	}
}
