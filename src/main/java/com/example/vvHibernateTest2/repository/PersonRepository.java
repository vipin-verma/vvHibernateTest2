package com.example.vvHibernateTest2.repository;


import com.example.vvHibernateTest2.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

