package com.crud.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.crud.validator.ResourceValidator;

public class EmailValidatorTest {

    private static final String BEAN_PROPERTY_STRING = "bean";

    private ResourceValidator validator;

    @BeforeEach
    public void before() {
        validator = new ResourceValidator();
    }

    @Test
    public void shouldRejectIfRequiredFieldsNull() {
        Object obj = new Object();

        Errors errors = new BeanPropertyBindingResult(null, BEAN_PROPERTY_STRING);
        validator.validate(obj, errors);
        assertThat(errors.hasErrors()).isTrue();

        assertErrorCode(errors, null, null);
    }

    private static void assertErrorCode(Errors errors, String field, String expectedCode) {
        assertThat(errors.getFieldError(field)).isNotNull();
        assertThat(errors.getFieldError(field).getCode()).isEqualTo(expectedCode);
    }
}
