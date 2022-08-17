package com.sap.cloud.cmp.ord.service.storage.model.helperentities;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@EdmIgnore
@Table(name = "industries_event_definitions")
@Entity(name = "industryEventDefinition")
@IdClass(IndustryEventDefinition.class)
public class IndustryEventDefinition implements Serializable {
    @javax.persistence.Id
    @Column(name = "event_definition_id", length = 256)
    private String eventDefID;

    @javax.persistence.Id
    @Column(name = "value", length = Integer.MAX_VALUE)
    private String value;
}