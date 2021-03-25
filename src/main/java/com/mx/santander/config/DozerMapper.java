package com.mx.santander.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerMapper {
	
	@Bean
	   public ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }
	
//	@Bean
//    public BeanMappingBuilder beanMappingBuilder() {
//		return new BeanMappingBuilder() {
//            @Override
//            protected void configure() {
//                mapping(Ambientes.class, AmbientesRequestDTO.class)
//                    .fields("id_ambiente", "id_ambiente");
//            }
//        };
//    }
//	
//	@Bean
//	public Mapper dozerBeanMapper() {
//		return beanMappingBuilder.create().build();
//	}
}