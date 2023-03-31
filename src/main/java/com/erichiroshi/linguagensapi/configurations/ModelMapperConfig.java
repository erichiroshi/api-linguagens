package com.erichiroshi.linguagensapi.configurations;

import org.modelmapper.Condition;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	Condition<Object, Object> skipNullFields = new Condition<Object, Object>() {
		@Override
		public boolean applies(MappingContext<Object, Object> context) {
			return context.getSource() != null;
		}
	};

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(skipNullFields);
		return modelMapper;
	}
}