package com.workshop.vote.domain.valueObject;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.Instant;

@Getter
@Embeddable
public class AuditableInfoValueObject {

    private String createdBy;
    private Instant createdAt;

    private String updatedBy;
    private Instant updatedAt;

    private String lastSourcePlatform;

    public AuditableInfoValueObject(String createdBy, String lastSourcePlatform) {
        this.createdBy = createdBy;
        this.createdAt = Instant.now();
        this.lastSourcePlatform = lastSourcePlatform;
    }

    public AuditableInfoValueObject(String createdBy, Instant createdAt, String lastSourcePlatform) {
        this(createdBy, lastSourcePlatform);
        this.createdAt = createdAt;
    }

    public AuditableInfoValueObject(String createdBy, Instant createdAt, String updatedBy, String lastSourcePlatform) {
        this(createdBy,createdAt, lastSourcePlatform);
        this.updatedBy = updatedBy;
        this.updatedAt = Instant.now();
    }

    public AuditableInfoValueObject(String createdBy, Instant createdAt, String updatedBy, Instant updatedAt, String lastSourcePlatform) {
        this(createdBy, createdAt, updatedBy, lastSourcePlatform);
        this.updatedAt = updatedAt;
    }
}
