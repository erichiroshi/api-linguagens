package com.erichiroshi.linguagensapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erichiroshi.linguagensapi.entities.Linguagem;
import com.erichiroshi.linguagensapi.services.LinguagemService;

@RestController
@RequestMapping("/linguagens")
public class LinguagemController {

	@Autowired
	private LinguagemService service;

	@GetMapping("/{id}")
	public ResponseEntity<Linguagem> findById(@PathVariable String id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<Linguagem>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping
	public ResponseEntity<Linguagem> insert(@RequestBody Linguagem linguagem) {
		linguagem = service.insert(linguagem);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(linguagem.getId()).toUri();
		return ResponseEntity.created(uri).body(linguagem);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Linguagem> update(@PathVariable String id, @RequestBody Linguagem linguagem) {
		linguagem.setId(id);
		linguagem = service.update(linguagem);
		return ResponseEntity.ok(linguagem);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Linguagem> deleteById(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
