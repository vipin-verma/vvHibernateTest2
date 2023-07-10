/*
package com.example.vvHibernateTest2.audit;

import com.example.vvHibernateTest2.model.CustomRevisionEntity;
import org.hibernate.envers.RevisionListener;

import java.util.Date;

public class AuditingRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity customRevisionEntity = (CustomRevisionEntity) revisionEntity;
        customRevisionEntity.setTimestamp(new Date().getTime());
    }
}
*/
