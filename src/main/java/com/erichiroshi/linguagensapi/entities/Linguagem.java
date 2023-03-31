package com.erichiroshi.linguagensapi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "principaisLinguagens")
public class Linguagem {

	@Id
	private String id;
	
	private String title;
	private String image;
	private Integer ranking;
}
