package com.aits.todorepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByCompleted(boolean completed);
}
