package com.aits.todocontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aits.Todo;
import com.aits.todorepo.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	TodoRepository todorepository;
	
	
	@PostMapping
	public Todo insert(@RequestBody Todo todo)
	
	{
		todorepository.save(todo);
		return todo;
	}
	
	@GetMapping
	public List<Todo> getAllTodos()
	{
		return todorepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		todorepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Todo update(@PathVariable long id,@RequestBody Todo todo)
	{
		if(todorepository.existsById(id))
		{
			todo.setId(id);
			return todorepository.save(todo);
		}
		return todo;
	}
	
	@GetMapping("/completed")
	public List<Todo> findByCompleted( )
	{
		return (List<Todo>)todorepository.findByCompleted(true);
	}
	@GetMapping("/notcompleted")
	public List<Todo> findByNotcompleted()
	{
		return (List<Todo>)todorepository.findByCompleted(false);
	}
			
}
