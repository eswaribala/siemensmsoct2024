package com.boa.customerapi.services;

import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.repositories.CorporateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CorporateService {

    @Autowired
    private CorporateRepo corporateRepo;


    //add

    public Corporate addCorporate(Corporate corporate){
        return this.corporateRepo.save(corporate);
    }

    //getall

    public List<Corporate> getAllCorporates(){
        return  this.corporateRepo.findAll();
    }

    //get by id

    public Corporate getCorporateById(long customerId){
        return this.corporateRepo.findById(customerId).orElse(null);
    }



    //update
    public Corporate updateCorporateByCustomerId(long customerId, String email){
        Corporate Corporate=this.getCorporateById(customerId);

        if(Corporate!=null){
            Corporate.setEmail(email);
            return this.corporateRepo.save(Corporate);
        }
        else
            return null;
    }


    //delete


    public boolean deleteCorporateByCustomerId(long customerId){
        boolean status=false;
        Corporate Corporate=this.getCorporateById(customerId);

        if(Corporate!=null){
            this.corporateRepo.deleteById(customerId);

            status=true;

        }
        return status;
    }

}
