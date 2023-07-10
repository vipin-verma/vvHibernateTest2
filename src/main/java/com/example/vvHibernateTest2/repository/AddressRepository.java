package com.example.vvHibernateTest2.repository;


import com.example.vvHibernateTest2.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
