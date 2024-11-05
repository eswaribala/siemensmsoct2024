package com.boa.customerapi.mutations;

import com.boa.customerapi.dtos.IndividualInput;
import com.boa.customerapi.models.FullName;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;

@Component
public class IndividualMutation implements GraphQLMutationResolver {

    @Autowired
    private IndividualService individualService;

    public Individual addIndividual(IndividualInput individualInput){

        Individual individual=Individual.builder()
                        .customerId(individualInput.getCustomerId())
                        .contactNo(individualInput.getContactNo())
                        .email(individualInput.getEmail())
                        .password(individualInput.getPassword())
                        .dob(individualInput.getDob())
                         .gender(individualInput.getGender())
                         .name(FullName.builder()
                                 .firstName(individualInput.getName().getFirstName())
                                 .lastName(individualInput.getName().getLastName())
                                 .middleName(individualInput.getName().getMiddleName())
                                 .build())
                        .build();

        return this.individualService.addIndividual(individual);

    }
    public Individual updateIndividual(long customerId, String email){
        return this.individualService.updateIndividualByCustomerId(customerId,email);
    }
    public boolean deleteIndividual(long customerId){

        return this.individualService.deleteIndividualByCustomerId(customerId);
    }
}
