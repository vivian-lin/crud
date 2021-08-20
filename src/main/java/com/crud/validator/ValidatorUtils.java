package com.crud.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

import com.crud.dto.ValidationError;
import com.crud.exception.ValidationException;

public class ValidatorUtils {

    public static ResponseEntity<ValidationError> unprocessableEntity(BindingResult result) {
        Map<String, List<String>> fieldErrors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            if (fieldErrors.containsKey(error.getField())) {
                fieldErrors.get(error.getField()).add(error.getCode());
            } else {
                List<String> errorCodes = new ArrayList<>();
                errorCodes.add(error.getCode());
                fieldErrors.put(error.getField(), errorCodes);
            }
        });

        return ResponseEntity.unprocessableEntity().body(new ValidationError(fieldErrors));
    }

    public static void validate(Object object, Validator validator) {
        DataBinder binder = new DataBinder(object);
        binder.setValidator(validator);
        binder.validate();

        BindingResult results = binder.getBindingResult();
        if (results.hasErrors()) {
            throw new ValidationException(results);
        }
    }

}
