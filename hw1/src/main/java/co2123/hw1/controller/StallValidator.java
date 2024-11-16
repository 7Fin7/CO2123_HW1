package co2123.hw1.controller;

import co2123.hw1.domain.Stall;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

public class StallValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Stall.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Stall stall = (Stall) target;

        // Reject if type empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "", "The stall needs a type");

        // Reject if owner empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner", "", "The stall needs an owner");

        // Reject if not a valid product

        if (!List.of("Fruit", "Vegetables", "Flowers").contains(stall.getProducts())) {
            errors.rejectValue("products", "", "The products must be either 'Fruit', 'Vegetables' or 'Flowers'");
        }

        // Reject out of hours
        if (stall.getHours() < 12 || stall.getHours() > 20) {
            errors.rejectValue("hours", "", "The hours must be between 12 and 20");
        }
    }
}
