package com.boa.customerapi.controllers;

import com.boa.customerapi.dtos.ResponseWrapper;
import com.boa.customerapi.models.Individual;
import com.boa.customerapi.services.IndividualService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/individuals")
public class IndividualController {
    private static final Logger LOGGER = LogManager.getLogger(IndividualController.class);
    @Autowired
    private IndividualService individualService;


    @PostMapping({"/v1.0/"})

    public ResponseEntity<ResponseWrapper> addIndividual(@RequestBody Individual individual){

        Individual obj=this.individualService.addIndividual(individual);
        if(obj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(obj));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Individual not added"));

    }

    @GetMapping({"/v1.0/"})
    public List<Individual> getAllIndividuals()
    {
        LOGGER.info(LocalDate.now()+"Fetching Data");
        List<Individual> individuals=this.individualService.getAllIndividuals();
        for(Individual individual : individuals)
            LOGGER.info(individual);
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");


        return individuals;
    }

    @GetMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> getIndividualByCustomerId(@PathVariable("customerId") long customerId)
    {
        Individual obj=this.individualService.getIndividualById(customerId);
        if(obj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(obj));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Individual not found"));

    }


    @GetMapping({"/v1.0/contacts/{contactNo}"})
    public ResponseEntity<ResponseWrapper> getIndividualByContactNo(@PathVariable("contactNo") long contactNo)
    {
        List<Individual> individuals=this.individualService.getIndividualByContactNo(contactNo);
        if(individuals.size()>0){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(individuals));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Individual not found"));

    }
    @GetMapping({"/v1.0/names/{firstName}"})
    public ResponseEntity<ResponseWrapper> getIndividualByFIrstName(@PathVariable("firstName") String firstName)
    {
        List<Individual> individuals=this.individualService.getIndividualByFirstName(firstName);
        if(individuals.size()>0){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(individuals));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Individual not found"));

    }

    @PutMapping({"/v1.0/{customerId}"})

    public ResponseEntity<ResponseWrapper> updateIndividual(@PathVariable("customerId") long customerId,@RequestParam("email") String email){

        Individual obj=this.individualService.updateIndividualByCustomerId(customerId,email);
        if(obj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(obj));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Individual not updated"));

    }
    @DeleteMapping({"/v1.0/{customerId}"})

    public ResponseEntity<ResponseWrapper> deleteIndividual(@PathVariable("customerId") long customerId){


        if(this.individualService.deleteIndividualByCustomerId(customerId)){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper("Individual Deleted Successfully"));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Individual not deleted"));

    }

}
