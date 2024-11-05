package com.boa.customerapi.controllers;

import com.boa.customerapi.dtos.ResponseWrapper;
import com.boa.customerapi.models.Corporate;
import com.boa.customerapi.services.CorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporates")
public class CorporateController {

    @Autowired
    private CorporateService corporateService;


    @PostMapping({"/v1.0/"})

    public ResponseEntity<ResponseWrapper> addCorporate(@RequestBody Corporate corporate){

        Corporate obj=this.corporateService.addCorporate(corporate);
        if(obj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(obj));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Corporate not added"));

    }

    @GetMapping({"/v1.0/"})
    public List<Corporate> getAllCorporates()
    {
        return this.corporateService.getAllCorporates();
    }

    @GetMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> getCorporateByCustomerId(@PathVariable("customerId") long customerId)
    {
        Corporate obj=this.corporateService.getCorporateById(customerId);
        if(obj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(obj));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Corporate not found"));

    }




    @PutMapping({"/v1.0/{customerId}"})

    public ResponseEntity<ResponseWrapper> updateCorporate(@PathVariable("customerId") long customerId,@RequestParam("email") String email){

        Corporate obj=this.corporateService.updateCorporateByCustomerId(customerId,email);
        if(obj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(obj));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Corporate not updated"));

    }
    @DeleteMapping({"/v1.0/{customerId}"})

    public ResponseEntity<ResponseWrapper> deleteCorporate(@PathVariable("customerId") long customerId){


        if(this.corporateService.deleteCorporateByCustomerId(customerId)){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper("Corporate Deleted Successfully"));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Corporate not deleted"));

    }

}
