package com.sap.cloud.cmp.ord.service.storage.model.helperentities;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@EdmIgnore
@Table(name = "links_entity_types")
@Entity(name = "linkEntityType")
@IdClass(LinkEntityType.class)
public class LinkEntityType implements Serializable {
    @javax.persistence.Id
    @Column(name = "entity_type_id", length = 256)
    private String entityTypeID;

    @javax.persistence.Id
    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @javax.persistence.Id
    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @javax.persistence.Id
    @Column(name = "url", length = Integer.MAX_VALUE)
    private String url;
}