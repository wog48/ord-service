package com.sap.cloud.cmp.ord.service.storage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OutputPort {
    @Column(name = "ord_id", length = Integer.MAX_VALUE, nullable = false)
    private String ordId;
}
