package com.workshop.vote.domain.enums;

public enum TopicStatusEnum {
    UNDEFINED(0),
    NEW(1),
    OPENED(2),
    CLOSED(3);

    private Integer value;

    TopicStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
