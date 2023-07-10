package com.example.vvHibernateTest2.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Audited
@AuditTable("add_aud")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    @NotAudited
    @Column(nullable = false)
    private String country;

}
