package com.boa.customerapi.mutations;

import com.boa.customerapi.dtos.CorporateInput;
import com.boa.customerapi.models.FullName;
import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorporateMutation implements GraphQLMutationResolver {

    @Autowired
    private CorporateService corporateService;

    public Corporate addCorporate(CorporateInput corporateInput){

        Corporate corporate=Corporate.builder()
                        .customerId(corporateInput.getCustomerId())
                        .contactNo(corporateInput.getContactNo())
                        .email(corporateInput.getEmail())
                        .password(corporateInput.getPassword())
                .companyType(corporateInput.getCompanyType())
                         .name(FullName.builder()
                                 .firstName(corporateInput.getName().getFirstName())
                                 .lastName(corporateInput.getName().getLastName())
                                 .middleName(corporateInput.getName().getMiddleName())
                                 .build())
                        .build();

        return this.corporateService.addCorporate(corporate);

    }
    public Corporate updateCorporate(long customerId, String email){
        return this.corporateService.updateCorporateByCustomerId(customerId,email);
    }
    public boolean deleteCorporate(long customerId){

        return this.corporateService.deleteCorporateByCustomerId(customerId);
    }
}
