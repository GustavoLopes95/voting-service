package com.workshop.vote.domain.valueObject;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class RegisterVersionValueObject {

    private Integer registerVersion;

    public RegisterVersionValueObject() {
        registerVersion = 1;
    }

    public RegisterVersionValueObject(Integer registerVersion) {
        this.registerVersion = registerVersion;
    }
}
