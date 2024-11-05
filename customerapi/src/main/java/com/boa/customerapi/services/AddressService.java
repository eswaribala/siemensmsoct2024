package com.boa.customerapi.services;

import com.boa.customerapi.models.Address;
import com.boa.customerapi.models.Customer;
import com.boa.customerapi.repositories.AddressRepo;
import com.boa.customerapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private CustomerRepo customerRepo;


    //add

    public Address addAddress(long customerId,Address address){

       Customer customer =this.customerRepo.findById(customerId).orElse(null);

       if(customer!=null){
           address.setCustomer(customer);
           return this.addressRepo.save(address);
       }else{
           return null;
       }



    }

    //getall

    public List<Address> getAllAddresss(){
        return  this.addressRepo.findAll();
    }

    //get by id

    public List<Address> getAddressByCustomerId(long customerId){
        return this.addressRepo.findByCustomerId(customerId);
    }



    //update
    public Address updateAddressByCustomerId(long addressId, String doorNo){
        Address address=this.addressRepo.findById(addressId).orElse(null);

        if(address!=null){
            address.setDoorNo(doorNo);
            return this.addressRepo.save(address);
        }
        else
            return null;
    }


    //delete


    public boolean deleteAddressByAddressId(long addressId){
        boolean status=false;
        Address address=this.addressRepo.findById(addressId).orElse(null);

        if(address!=null){
            this.addressRepo.deleteById(addressId);

            status=true;

        }
        return status;
    }


}
