package com.workshop.vote.application.inputs;

import br.com.fluentvalidator.AbstractValidator;
import com.workshop.vote.domain.messages.BaseMessage;
import com.workshop.vote.infra.crossCutting.messages.BaseInput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VoteInput extends BaseInput implements Serializable {
    public static final Long serialVersionUID = 1L;
    private Long topicId;
    private UUID messageId;
    private String messageType;
    private String sourcePlatform;


    @Override
    public Boolean isValid() {
        this.validator = new VoteCommandValidation().validate(this);
        return this.validator.isValid();
    }

    private class VoteCommandValidation extends AbstractValidator<VoteInput> {

        @Override
        public void rules() {
            ruleFor(VoteInput::getTopicId)
                    .must(not(nullValue()))
                    .withMessage("Topic Id is required!")
                    .withFieldName("topicId");
        }
    }
}
