package com.hydropowerplant.waterlevel.businesslayer.annotation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
    
    public void initialize(PhoneNumber constraintAnnotation) {
        // Do nothing
    }

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            return phoneNumberUtil.isValidNumber(
                    phoneNumberUtil.parse(value, Phonenumber.PhoneNumber.CountryCodeSource.UNSPECIFIED.name()));
        } catch (NumberParseException e) {
            return false;
        }
    }

}
