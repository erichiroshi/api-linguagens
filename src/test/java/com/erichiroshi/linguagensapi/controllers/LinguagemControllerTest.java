package com.erichiroshi.linguagensapi.controllers;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.erichiroshi.linguagensapi.entities.Linguagem;
import com.erichiroshi.linguagensapi.repositories.LinguagemRepository;
import com.erichiroshi.linguagensapi.services.LinguagemService;

import io.restassured.http.ContentType;;

@WebMvcTest
public class LinguagemControllerTest {

	@Autowired
	private LinguagemController linguagemController;
	
	@MockBean
	private LinguagemService linguagemService;
	
	@MockBean
	private LinguagemRepository linguagemRepository;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.linguagemController);
	}

	@Test
	public void deveRetornarSucesso_QuandoBuscarLinguagem() {
		when(this.linguagemService.findById("64258c1a6e85dae77f9e5293")).thenReturn(new Linguagem());
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/linguagens/{id}", "64258c1a6e85dae77f9e5293")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontardo_QuandoBuscarLinguagem() {
		when(this.linguagemRepository.findById("64258c1a6e85dae77f9e5293asfasfas")).thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/linguagens/{id}", "64258c1a6e85dae77f9e5293asfasfas")
		.then()
			.statusCode(HttpStatus.OK.value());
	}

}
