package com.taskmanagement.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomDateValidator implements
  ConstraintValidator<CustomDateConstraint, LocalDate> {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public void initialize(CustomDateConstraint customDate) {
    }

    @Override
    public boolean isValid(LocalDate customDateField,
      ConstraintValidatorContext cxt) {
          SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
           try
        {
            sdf.setLenient(false);
            Date d = sdf.parse(customDateField.toString());
            return true;
        }
        catch (ParseException e) {
        	e.printStackTrace();
            return false;
        }
    }

}