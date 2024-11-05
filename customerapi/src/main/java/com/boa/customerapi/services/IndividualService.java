package com.boa.customerapi.services;

import com.boa.customerapi.models.Individual;
import com.boa.customerapi.repositories.IndividualRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class IndividualService {
    @Autowired
    private IndividualRepo individualRepo;

    @Autowired
    private EntityManager entityManager;

    //add

    public Individual addIndividual(Individual individual){
        return this.individualRepo.save(individual);
    }

    //getall

    public List<Individual> getAllIndividuals(){
        return  this.individualRepo.findAll();
    }

    //get by id

    public Individual getIndividualById(long customerId){
        return this.individualRepo.findById(customerId).orElse(null);
    }

//non primary key
    public List<Individual> getIndividualByContactNo(long contactNo){
        return this.individualRepo.findByContactNo(contactNo);
    }

//non primary key
    public List<Individual> getIndividualByFirstName(String firstName){

        CriteriaBuilder cb= entityManager.getCriteriaBuilder();
        AbstractQuery<Individual> cq=cb.createQuery(Individual.class);

        Root<Individual> individualObject=cq.from(Individual.class);
        cq.where(cb.equal(individualObject.get("name").<String> get("firstName") ,firstName));

        CriteriaQuery<Individual> selectResult=((CriteriaQuery<Individual>)cq).select(individualObject);
        TypedQuery<Individual> tq=entityManager.createQuery(selectResult);
        return tq.getResultList();

    }

    //update
    public Individual updateIndividualByCustomerId(long customerId, String email){
        Individual individual=this.getIndividualById(customerId);

        if(individual!=null){
            individual.setEmail(email);
            return this.individualRepo.save(individual);
        }
        else
            return null;
    }


    //delete


    public boolean deleteIndividualByCustomerId(long customerId){
        boolean status=false;
        Individual individual=this.getIndividualById(customerId);

        if(individual!=null){
            this.individualRepo.deleteById(customerId);

            status=true;

            }
       return status;
    }




}
