package com.example.vvHibernateTest2.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "person")
@Audited
@AuditTable("feature_aud")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotAudited
    @Column(nullable = false)
    private String name;


    @NotAudited
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String title;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NotAudited
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private Address address;


}
