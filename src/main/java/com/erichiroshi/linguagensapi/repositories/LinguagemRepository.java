package com.erichiroshi.linguagensapi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.erichiroshi.linguagensapi.entities.Linguagem;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {

	List<Linguagem> findByOrderByRanking();

}
