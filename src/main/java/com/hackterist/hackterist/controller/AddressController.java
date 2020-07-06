package com.hackterist.hackterist.controller;

import com.hackterist.hackterist.model.Address;
import com.hackterist.hackterist.repository.AddressRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {

    private final AddressRepository addressDao;

    public AddressController(AddressRepository addressDao) {
        this.addressDao = addressDao;
    }

    /*
     * Access the Model interface for form model binding by assigning
     * addressModel as a parameter. The "address" string name is then
     * used to bind the model data to the view.
     * The "/address" end-point returns the address.html file
     */
    @GetMapping("/address")
    public String getAddressForm(Model addressModel){
        addressModel.addAttribute("address", new Address());
        return "user/address";
    }


    /*
    * POST mapping used for the form Action.
    * Using addressDao and invoking the method 'save' to persist
    * form data entered by the user.
    * Returns to the /address URL after the form is completed
    */
    @PostMapping("/address")
    public String saveAddressForm(@ModelAttribute Address newAddress) {
        addressDao.save(newAddress);
        return "index";
    }

    /*
    * GET Mapping to pull a list of addresses from the database
    *
    */
    @GetMapping("/list")
    public String listOfAddress(){
        return "user/list";
    }
}
