package com.BacthXP.Simple.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.BacthXP.Simple.Pojo.Todo;

@Repository
public class TodoInmemoryRepository {
 //inmemory logic
  private static final Map<Integer, Todo> map = new HashMap<>();
 
  
  
  public List<Todo> getAllTodosFromRepository(){
	  //return new ArrayList<>(map.values());
	  List<Todo> result = map.values().stream().collect(Collectors.toList());
	  return result;
  }
  
  
}
