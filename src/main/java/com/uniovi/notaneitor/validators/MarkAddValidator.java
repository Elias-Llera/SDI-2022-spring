package com.uniovi.notaneitor.validators;

import com.uniovi.notaneitor.entities.Mark;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MarkAddValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Mark.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");
        if (mark.getScore() < 0 || mark.getScore() > 10) {
            errors.rejectValue("score", "Error.mark.score.range");
        }
        if(mark.getDescription().trim().length()<20){
            errors.rejectValue("description", "Error.mark.description.length");
        }
    }
}
