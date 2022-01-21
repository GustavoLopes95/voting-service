package com.workshop.vote.domain.valueObject;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class RegisterVersion {

    private Integer registerVersion;

    public RegisterVersion() {
        registerVersion = 1;
    }

    public RegisterVersion(Integer registerVersion) {
        this.registerVersion = registerVersion;
    }
}
