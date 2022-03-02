package com.workshop.vote.application.inputs;

import br.com.fluentvalidator.AbstractValidator;
import com.workshop.vote.infra.crossCutting.messages.BaseInput;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

@Getter
@NoArgsConstructor
public class CreateTopicInput extends BaseInput {

    private String name;

    private Long secondsDuration;

    public CreateTopicInput(String topicName, Long secondsDuration) {
        this.name = topicName;
        this.secondsDuration = secondsDuration;
    }

    public Boolean isValid() {
        this.validator = new CreateTopicCommandValidation().validate(this);
        return this.validator.isValid();
    }

    private class CreateTopicCommandValidation extends AbstractValidator<CreateTopicInput> {
        @Override
        public void rules() {
            ruleFor(CreateTopicInput::getName)
                    .must(not(stringEmptyOrNull()))
                    .withMessage("Topic name is required!")
                    .withFieldName("name");

            ruleFor(CreateTopicInput::getSecondsDuration)
                    .must(not(nullValue()))
                        .withMessage("Topic duration is required!")
                        .withFieldName("secondsDuration")
                    .must(greaterThan(0L))
                        .withMessage("Topic duration must be greater than 0")
                        .withFieldName("secondsDuration");
        }
    }
}
