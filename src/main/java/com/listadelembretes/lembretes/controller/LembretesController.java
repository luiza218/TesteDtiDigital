package com.listadelembretes.lembretes.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.listadelembretes.lembretes.entities.Lembretes;
import com.listadelembretes.lembretes.repository.LembretesRepository;

@RestController
public class LembretesController {
	LembretesRepository repo;

	public LembretesController(LembretesRepository repo) {
		super();
		this.repo = repo;
	} 

	@GetMapping("/lembretes")
	public List<Lembretes> getAll() {
		List<Lembretes> result = new ArrayList<>();
		Iterable<Lembretes> iterable = repo.findAll();

		iterable.forEach(result::add);

		return result;
		
	}

	@PostMapping("/lembretes")
	public Lembretes save(@RequestBody Lembretes lembrete) {
		
		repo.save(lembrete);
		return lembrete;
		
	}

	@GetMapping("/lembretes/{id}")
	public Lembretes getById(@PathVariable long id) {
		return repo.findById(id).get();
	}

	@DeleteMapping("/lembretes/{id}")
	public void deleteById(@PathVariable long id) {
		repo.deleteById(id);
	}

}
