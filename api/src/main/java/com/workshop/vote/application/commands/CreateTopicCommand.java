package com.workshop.vote.application.commands;

import br.com.fluentvalidator.AbstractValidator;
import com.workshop.vote.infra.crossCutting.messages.BaseCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Getter
@NoArgsConstructor
public class CreateTopicCommand extends BaseCommand {

    private String name;

    private Long secondsDuration;

    public CreateTopicCommand(String topicName, Long secondsDuration) {
        this.name = topicName;
        this.secondsDuration = secondsDuration;
    }

    public Boolean isValid() {
        this.validator = new CreateTopicCommandValidation().validate(this);
        return this.validator.isValid();
    }

    private class CreateTopicCommandValidation extends AbstractValidator<CreateTopicCommand> {
        @Override
        public void rules() {
            ruleFor(CreateTopicCommand::getName)
                    .must(not(stringEmptyOrNull()))
                    .withMessage("Topic name is required!")
                    .withFieldName("name");

            ruleFor(CreateTopicCommand::getSecondsDuration)
                    .must(not(nullValue()))
                        .withMessage("Topic duration is required!")
                        .withFieldName("secondDuration")
                    .must(greaterThan(0L))
                        .withMessage("Topic duration must be greater than 0")
                        .withFieldName("secondDuration");
        }
    }
}
