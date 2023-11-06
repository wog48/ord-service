package com.sap.cloud.cmp.ord.service.storage.model.helperentities;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@EdmIgnore
@Table(name = "correlation_ids_integration_dependencies")
@Entity(name = "correlationIdIntegrationDependency")
@IdClass(CorrelationIdIntegrationDependency.class)
public class CorrelationIdIntegrationDependency implements Serializable {
    @javax.persistence.Id
    @Column(name = "integration_dependency_id", length = 256)
    private String integrationDependencyId;

    @javax.persistence.Id
    @Column(name = "value", length = Integer.MAX_VALUE)
    private String value;
}