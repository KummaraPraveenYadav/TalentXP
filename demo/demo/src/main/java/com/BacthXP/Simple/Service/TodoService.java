package com.BacthXP.Simple.Service;

import java.util.List;

import com.BacthXP.Simple.Pojo.TodoDto;


public interface TodoService {

	public List<TodoDto> getAllTodosFromServiceImpl();
	public TodoDto getTodoById(Long id);
	public TodoDto addTodo(TodoDto todoDto);
	public boolean deleteTodo(Long id);
	public TodoDto updateTodo(Long id,TodoDto todoDto);
}
