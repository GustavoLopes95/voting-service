package com.workshop.vote.application.commands;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.LogicalPredicate;
import br.com.fluentvalidator.predicate.ObjectPredicate;
import com.workshop.vote.infra.crossCutting.messages.BaseCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;

@Getter
@NoArgsConstructor
public class VoteCommand extends BaseCommand {

    private Long topicId;

    public VoteCommand(Long topicId) {
        this.topicId = topicId;
    }

    @Override
    public Boolean isValid() {
        this.validator = new VoteCommandValidation().validate(this);
        return this.validator.isValid();
    }

    private class VoteCommandValidation extends AbstractValidator<VoteCommand> {

        @Override
        public void rules() {
            ruleFor(VoteCommand::getTopicId)
                    .must(not(nullValue()))
                    .withMessage("Topic Id is required!")
                    .withFieldName("topicId");
        }
    }
}
