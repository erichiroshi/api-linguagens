package com.erichiroshi.linguagensapi.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.erichiroshi.linguagensapi.entities.Linguagem;
import com.erichiroshi.linguagensapi.repositories.LinguagemRepository;

@Service
public class LinguagemService {

	@Autowired
	private LinguagemRepository repository;

	@Autowired
	private ModelMapper modelMmapper;

	public Linguagem findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

	public List<Linguagem> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "ranking"));
	}

	public Linguagem insert(Linguagem linguagem) {
		return repository.save(linguagem);
	}

	public Linguagem update(Linguagem linguagemAtualizada) {
		Linguagem linguagemExistente = findById(linguagemAtualizada.getId());
		modelMmapper.map(linguagemAtualizada, linguagemExistente);
		return repository.save(linguagemExistente);
	}

	public void deleteById(String id) {
		repository.deleteById(id);
	}

}