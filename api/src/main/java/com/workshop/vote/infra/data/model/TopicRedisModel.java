package com.workshop.vote.infra.data.model;

import com.workshop.vote.domain.enums.TopicStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TopicRedisModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    public String name;

    public Integer status;

    public LocalDateTime expirationTime;

    public TopicRedisModel(Long id, String name, TopicStatusEnum status, LocalDateTime expirationTime) {
        this.id = id;
        this.name = name;
        this.status = status.getValue();
        this.expirationTime = expirationTime;
    }
}
