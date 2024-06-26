package com.sap.cloud.cmp.ord.service.storage.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.TypeConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmProtectedBy;

import jakarta.validation.constraints.NotNull;

@Entity(name = "capability")
@Table(name = "tenants_capabilities")
public class CapabilityEntity {
    @Id
    @Column(name = "id")
    @Convert("uuidConverter")
    @TypeConverter(name = "uuidConverter", dataType = Object.class, objectType = UUID.class)
    private UUID Id;

    @Column(name = "package_id", nullable = false)
    @Convert("uuidConverter")
    @TypeConverter(name = "uuidConverter", dataType = Object.class, objectType = UUID.class)
    private UUID partOfPackage;

    @Column(name = "name", length = 256, nullable = false)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "ord_id", length = 256, nullable = false)
    private String ordId;

    @Column(name = "type", length = 256, nullable = false)
    private String type;

    @Column(name = "custom_type", length = Integer.MAX_VALUE)
    private String customType;

    @Column(name = "local_tenant_id", length = 256)
    private String localId;

    @Column(name = "short_description", length = 256)
    private String shortDescription;

    @Column(name = "system_instance_aware")
    private boolean systemInstanceAware;

    @ElementCollection
    @CollectionTable(name = "tags_capabilities", joinColumns = @JoinColumn(name = "capability_id"))
    private List<ArrayElement> tags;

    @ElementCollection
    @CollectionTable(name = "entity_types_capabilities", joinColumns = @JoinColumn(name = "capability_id"))
    private List<ArrayElement> relatedEntityTypes;

    @ElementCollection
    @CollectionTable(name = "links_capabilities", joinColumns = @JoinColumn(name = "capability_id"))
    private List<Link> links;

    @Column(name = "release_status", nullable = false)
    private String releaseStatus;

    @Column(name = "version_value", nullable = false)
    private String version;

    @ElementCollection
    @CollectionTable(name = "ord_labels_capabilities", joinColumns = @JoinColumn(name = "capability_id"))
    private List<Label> labels;

    @EdmProtectedBy(name = "visibility_scope")
    @Column(name = "visibility", nullable = false)
    private String visibility;

    @ElementCollection
    @CollectionTable(name = "ord_documentation_labels_capabilities", joinColumns = @JoinColumn(name = "capability_id"))
    private List<Label> documentationLabels;

    @ElementCollection
    @CollectionTable(name = "correlation_ids_capabilities", joinColumns = @JoinColumn(name = "capability_id", referencedColumnName= "id"))
    private List<ArrayElement> correlationIds;

    @Column(name = "last_update")
    private String lastUpdate;

    @ElementCollection
    @CollectionTable(name = "capability_definitions", joinColumns = @JoinColumn(name = "capability_def_id"))
    private List<CapabilityDefinition> definitions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "package_id", referencedColumnName = "id", insertable = false, updatable = false),
            @JoinColumn(name = "formation_id", referencedColumnName = "formation_id", insertable = false, updatable = false),
    })
    private PackageEntity pkg;

    @EdmIgnore
    @Column(name = "app_id", length = 256)
    @Convert("uuidConverter")
    @TypeConverter(name = "uuidConverter", dataType = Object.class, objectType = UUID.class)
    private UUID appId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "app_id", referencedColumnName = "id", insertable = false, updatable = false),
            @JoinColumn(name = "formation_id", referencedColumnName = "formation_id", insertable = false, updatable = false),
    })
    private SystemInstanceEntity systemInstance;

    @EdmProtectedBy(name = "tenant_id")
    @EdmIgnore
    @Column(name = "tenant_id", length = 256)
    @Convert("uuidConverter")
    @TypeConverter(name = "uuidConverter", dataType = Object.class, objectType = UUID.class)
    private UUID tenant;

    @EdmProtectedBy(name = "formation_scope")
    @EdmIgnore
    @Column(name = "formation_id")
    @Convert("uuidConverter")
    @TypeConverter(name = "uuidConverter", dataType = Object.class, objectType = UUID.class)
    private UUID formationID;
}