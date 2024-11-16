package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Market;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MarketValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Market.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Market market = (Market) target;

        // Check if id is unique
        for (Market m : Hw1Application.markets) {
            if (m.getId() == market.getId()) {
                errors.rejectValue("id", "", "ID already in use");
            }
        }

        // Reject if name empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "The market needs a name");

        // Reject if location empty
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "", "The market needs a location");
    }
}
