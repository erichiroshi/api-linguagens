package com.erichiroshi.linguagensapi.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.erichiroshi.linguagensapi.entities.Linguagem;


@RunWith(SpringRunner.class)
public class LinguagemServiceTest {

	@Autowired
	LinguagemService linguagemService;
	
	@Test
	public void findByIdTest(String id) {
		
		
		
		Linguagem linguagem = linguagemService.findById(id);
		Assertions.assertEquals("Java", linguagem);
	}
	
}
