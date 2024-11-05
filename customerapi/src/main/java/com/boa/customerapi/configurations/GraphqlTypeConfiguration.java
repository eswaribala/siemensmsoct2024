package com.boa.customerapi.configurations;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlTypeConfiguration {


    @Bean
    public GraphQLScalarType getDate(){

        return ExtendedScalars.Date;
    }


    @Bean
    public GraphQLScalarType getJson(){

        return ExtendedScalars.Json;
    }


}
