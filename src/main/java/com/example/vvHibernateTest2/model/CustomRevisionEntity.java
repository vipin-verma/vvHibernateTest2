/*
package com.example.vvHibernateTest2.model;

import com.example.vvHibernateTest2.audit.AuditingRevisionListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "REVINFO")
@RevisionEntity(AuditingRevisionListener.class)
@Getter
@Setter
public class CustomRevisionEntity {
    @Id
    @GeneratedValue
    @RevisionNumber
    private int id;

    @RevisionTimestamp
    private long timestamp;

    // other fields and methods...
}

*/
