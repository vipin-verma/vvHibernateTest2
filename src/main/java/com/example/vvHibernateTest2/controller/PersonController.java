package com.example.vvHibernateTest2.controller;

import com.example.vvHibernateTest2.model.Address;
import com.example.vvHibernateTest2.model.Person;
import com.example.vvHibernateTest2.service.AddressService;
import com.example.vvHibernateTest2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) throws Exception{
        Address address = person.getAddress();
        if (address != null) {
            if (address.getId() != null) {
                // If the address has an ID, try to fetch the existing address
                Address existingAddress = addressService.getAddressById(address.getId());
                if (existingAddress != null) {
                    // If the address exists, use it
                    person.setAddress(existingAddress);
                } else {
                    // If the address doesn't exist, clear the ID and save it as a new address
                    address.setId(null);
                    Address newAddress = addressService.createAddress(address);
                    person.setAddress(newAddress);
                }
            } else {
                // If the address doesn't have an ID, save it as a new address
                Address newAddress = addressService.createAddress(address);
                person.setAddress(newAddress);
            }
        }
          personService.createPerson(person);
        throw new SQLException("test");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        Optional<Person> optionalPerson = Optional.ofNullable(personService.getPersonById(id));

        if (!optionalPerson.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Person person = optionalPerson.get();
        person.setName(personDetails.getName());
        person.setEmail(personDetails.getEmail());
        person.setTitle(personDetails.getTitle());

        Address address = personDetails.getAddress();
        if (address != null) {
            if (address.getId() != null) {
                Address existingAddress = addressService.getAddressById(address.getId());
                if (existingAddress != null) {
                    person.setAddress(existingAddress);
                } else {
                    address.setId(null);
                    Address newAddress = addressService.createAddress(address);
                    person.setAddress(newAddress);
                }
            } else {
                Address newAddress = addressService.createAddress(address);
                person.setAddress(newAddress);
            }
        }

        Person updatedPerson = personService.updatePerson(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}

