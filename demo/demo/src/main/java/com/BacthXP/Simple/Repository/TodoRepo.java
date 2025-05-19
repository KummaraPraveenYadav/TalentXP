package com.BacthXP.Simple.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BacthXP.Simple.Pojo.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
}
