package com.workshop.vote.infra.data.mapper;

import com.workshop.vote.domain.valueObject.VoteValueObject;
import com.workshop.vote.infra.data.model.VoteModel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class VoteMapper {

//    @Autowired
//    private TopicMapper topicMapper;

    public VoteModel toRepository(VoteValueObject voteVO) {
//        var model = topicMapper.toRepository(voteVO.getTopic());
        return new VoteModel(
                voteVO.getVotedAt()
        );
    }

}
