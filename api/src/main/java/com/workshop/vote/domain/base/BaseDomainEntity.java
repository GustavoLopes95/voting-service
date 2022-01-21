package com.workshop.vote.domain.base;

import com.workshop.vote.domain.valueObject.AuditableInfoValueObject;
import com.workshop.vote.domain.valueObject.RegisterVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@MappedSuperclass
@NoArgsConstructor
public class BaseDomainEntity {

    //Property
    @Id
    private Long id;

    private AuditableInfoValueObject auditableInfo;

    private RegisterVersion version;

    //Private Methods
    private BaseDomainEntity generateNewRegisterVersion() {
        version = new RegisterVersion();
        return this;
    }

    private BaseDomainEntity setRegisterVersionInfo(Integer registerVersion) {
        version = new RegisterVersion(registerVersion);
        return this;
    }

    private BaseDomainEntity generateNewAuditableInfoValueObject(String createdBy, String lastSourcePlatform) {
        auditableInfo = new AuditableInfoValueObject(createdBy, lastSourcePlatform);
        return this;
    }

    private BaseDomainEntity setAuditableInfoValueObject(
            String createdBy,
            Instant createdAt,
            String updatedBy,
            Instant updatedAt,
            String lastSourcePlatform
    ) {
        auditableInfo = new AuditableInfoValueObject(
                createdBy,
                createdAt,
                updatedBy,
                updatedAt,
                lastSourcePlatform
        );
        return this;
    }

    private BaseDomainEntity setIdInfo(Long id) {
        this.id = id;
        return this;
    }

    //Protected Methods
    protected BaseDomainEntity createNewRegister(String createdBy, String lastSourcePlatform) {
        return this
                .generateNewAuditableInfoValueObject(createdBy, lastSourcePlatform)
                .generateNewRegisterVersion();
    }

    protected BaseDomainEntity setRegisterInfo(
            Long id,
            String createdBy,
            Instant createdAt,
            String updatedBy,
            Instant updatedAt,
            String lastSourcePlatform,
            Integer registerVersion
    ) {
        return this
                .setIdInfo(id)
                .setAuditableInfoValueObject(
                    createdBy,
                    createdAt,
                    updatedBy,
                    updatedAt,
                    lastSourcePlatform
                )
                .setRegisterVersionInfo(registerVersion);
    }
}
