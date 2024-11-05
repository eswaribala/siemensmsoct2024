package com.boa.customerapi.controllers;

import com.boa.customerapi.dtos.ResponseWrapper;
import com.boa.customerapi.models.Address;
import com.boa.customerapi.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @PostMapping({"/v1.0/{customerId}"})

    public ResponseEntity<ResponseWrapper> addAddress(@PathVariable("customerId") long customerId,@RequestBody Address address){

        Address obj=this.addressService.addAddress(customerId,address);
        if(obj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(obj));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Address not added"));

    }

    @GetMapping({"/v1.0/"})
    public List<Address> getAllAddresss()
    {
        return this.addressService.getAllAddresss();
    }

    @GetMapping({"/v1.0/{customerId}"})
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable("customerId") long customerId)
    {
        List<Address> addresses=this.addressService.getAddressByCustomerId(customerId);
        if(addresses.size()>0){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(addresses));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Address not found"));

    }




    @PutMapping({"/v1.0/{addressId}"})

    public ResponseEntity<ResponseWrapper> updateAddress(@PathVariable("addressId") long addressId,@RequestParam("email") String email){

        Address obj=this.addressService.updateAddressByCustomerId(addressId,email);
        if(obj!=null){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(obj));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Address not updated"));

    }
    @DeleteMapping({"/v1.0/{addressId}"})

    public ResponseEntity<ResponseWrapper> deleteAddress(@PathVariable("addressId") long addressId){


        if(this.addressService.deleteAddressByAddressId(addressId)){

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper("Address Deleted Successfully"));
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseWrapper("Address not deleted"));

    }

}
