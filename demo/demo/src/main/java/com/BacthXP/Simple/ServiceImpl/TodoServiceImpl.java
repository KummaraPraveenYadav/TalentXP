package com.BacthXP.Simple.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BacthXP.Simple.Annotation.ExecutionTime;
import com.BacthXP.Simple.Pojo.Todo;
import com.BacthXP.Simple.Pojo.TodoDto;
import com.BacthXP.Simple.Repository.TodoInmemoryRepository;
import com.BacthXP.Simple.Repository.TodoRepo;
import com.BacthXP.Simple.Service.TodoService;
import com.BacthXP.Simple.SingleTone.ModelMapperSingleTone;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoInmemoryRepository todoInMemoryRepository;

	@Autowired
	private TodoRepo todoRepo;

	private ModelMapper modelMapper = ModelMapperSingleTone.modelMapper();

	@ExecutionTime
	@Override
	public List<TodoDto> getAllTodosFromServiceImpl() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Todo> allTodos = todoRepo.findAll();
		List<TodoDto> todoDto = new ArrayList<>();
		allTodos.forEach(todo -> {
			todoDto.add(modelMapper.map(todo, TodoDto.class));
		});
		return todoDto;
	}

	@Override
	public TodoDto getTodoById(Long id) {
		Optional<Todo> todoOpt = todoRepo.findById(id);
		return todoOpt.map(todo -> modelMapper.map(todo, TodoDto.class)).orElse(null);
	}

	@Override
	public TodoDto addTodo(TodoDto todoDto) {

		Todo todo = modelMapper.map(todoDto, Todo.class);
		Todo save = todoRepo.save(todo);
		return modelMapper.map(save, TodoDto.class);
	}

	@Override
	public boolean deleteTodo(Long id) {
		todoRepo.deleteById(id);
		return true;
	}

	@Override
	public TodoDto updateTodo(Long id, TodoDto todoDto) {
		Optional<Todo> todoById = todoRepo.findById(id);
		if (todoById.isPresent()) {
			Todo todoExist = todoById.get();

			todoExist.setName(todoDto.getName());
			todoExist.setDescription(todoDto.getDescription());
			todoExist.setStartTime(todoDto.getStartTime());
			todoExist.setEndTime(todoDto.getEndTime());
			Todo saveTodo = todoRepo.save(todoExist);
			return modelMapper.map(saveTodo, TodoDto.class);
		}
		return null;
	}
}
