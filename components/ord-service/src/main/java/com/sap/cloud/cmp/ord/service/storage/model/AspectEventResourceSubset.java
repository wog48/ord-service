package com.sap.cloud.cmp.ord.service.storage.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AspectEventResourceSubset {
    @Column(name = "event_type", length = Integer.MAX_VALUE)
    private String eventType;
}