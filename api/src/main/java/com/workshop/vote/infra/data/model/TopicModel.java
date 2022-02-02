package com.workshop.vote.infra.data.model;

import com.workshop.vote.domain.base.BaseDomainEntity;
import com.workshop.vote.domain.enums.TopicStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Entity( name = "topic")
@Getter
public class TopicModel extends BaseDomainEntity {

    //Private Properties
    private String name;

    private TopicStatusEnum status;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;

    @Column(name = "closed_time")
    private Instant closedTime;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VoteModel> votes = new ArrayList<>();

    public TopicModel(String name, TopicStatusEnum status, LocalDateTime expirationTime) {
        this.name = name;
        this.status = status;
        this.expirationTime = expirationTime;
    }

    public TopicModel(String name, TopicStatusEnum status, LocalDateTime expirationTime, String createdBy, String lastSourcePlatform) {
        this(name, status, expirationTime);
        this.createNewRegister(createdBy, lastSourcePlatform);
    }

    public TopicModel(Long id, String name, TopicStatusEnum status, LocalDateTime expirationTime, String createdBy, Instant createdAt, String updatedBy, Instant updatedAt, String lastSourcePlatform, Integer registerVersion) {
        this(name, status, expirationTime);
        this.setRegisterInfo(id, createdBy, createdAt, updatedBy, updatedAt, lastSourcePlatform, registerVersion);
    }

    public TopicModel(Long id, String name, TopicStatusEnum status, LocalDateTime expirationTime, Instant closedTime, String createdBy, Instant createdAt, String updatedBy, Instant updatedAt, String lastSourcePlatform, Integer registerVersion) {
        this(name, status, expirationTime);
        this.closedTime = closedTime;
        this.setRegisterInfo(id, createdBy, createdAt, updatedBy, updatedAt, lastSourcePlatform, registerVersion);
    }

    public void addVotes(VoteModel vm) {
        vm.attachTopic(this);
        this.votes.add(vm);
    }
}
