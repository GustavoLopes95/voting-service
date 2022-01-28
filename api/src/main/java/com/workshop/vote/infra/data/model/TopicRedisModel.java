package com.workshop.vote.infra.data.model;

import com.workshop.vote.domain.enums.TopicStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class TopicRedisModel implements Serializable {
    public static Long SERIAL_ID = 1L;

    @Id
    public Long id;

    public String name;

    public Integer status;

    public TopicRedisModel(Long id, String name, TopicStatusEnum status) {
        this.id = id;
        this.name = name;
        this.status = status.getValue();
    }
}
