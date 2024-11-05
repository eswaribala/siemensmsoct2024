package com.boa.customerapi.mutations;

import com.boa.customerapi.dtos.AddressInput;
import com.boa.customerapi.models.Address;
import com.boa.customerapi.models.Customer;
import com.boa.customerapi.models.FullName;
import com.boa.customerapi.services.AddressService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressMutation implements GraphQLMutationResolver {
    @Autowired
    private AddressService addressService;


    public Address addAddress(long customerId,AddressInput addressInput){
        Address address=null;
       if(addressInput.getCustomer()!=null) {
           address = Address.builder()
                   .addressId(addressInput.getAddressId())
                   .city(addressInput.getCity())
                   .doorNo(addressInput.getDoorNo())
                   .pincode(addressInput.getPincode())
                   .streetName(addressInput.getStreetName())
                   .customer(Customer.builder()
                           .customerId(addressInput.getCustomer().getCustomerId())
                           .contactNo(addressInput.getCustomer().getContactNo())
                           .email(addressInput.getCustomer().getEmail())
                           .password(addressInput.getCustomer().getPassword())

                           .name(FullName.builder()
                                   .firstName(addressInput.getCustomer().getName().getFirstName())
                                   .lastName(addressInput.getCustomer().getName().getLastName())
                                   .middleName(addressInput.getCustomer().getName().getMiddleName())

                                   .build())
                           .build())
                   .build();
       }
       else {
           address = Address.builder()
                   .addressId(addressInput.getAddressId())
                   .city(addressInput.getCity())
                   .doorNo(addressInput.getDoorNo())
                   .pincode(addressInput.getPincode())
                   .streetName(addressInput.getStreetName())
                   .build();
       }


        return this.addressService.addAddress(customerId,address);

    }
    public Address updateAddress(long addressId, String doorNo){
        return this.addressService.updateAddressByCustomerId(addressId,doorNo);
    }
    public boolean deleteAddress(long addressId){

        return this.addressService.deleteAddressByAddressId(addressId);
    }
}
