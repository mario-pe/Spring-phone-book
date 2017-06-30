package phoneValidator;

import service.PhoneService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by mario on 30.06.2017.
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {

    @Override
    public void initialize(PhoneNumber phoneNumber) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        PhoneService phoneService;
        if(phoneNumber == null){
            return false;
        }
        if(phoneNumber.matches("[0-9]{3}[- ][0-9]{3}[- ][0-9]{3}")){
            return true;
        }
        else return false;
    }
}
