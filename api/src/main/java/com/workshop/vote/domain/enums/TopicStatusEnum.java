package com.workshop.vote.domain.enums;

public enum TopicStatusEnum {
    UNDEFINED(0),
    OPENED(1),
    CLOSED(2);

    private Integer value;

    TopicStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
