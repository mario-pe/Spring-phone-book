package validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Created by mario on 30.06.2017.
 */
@Target({METHOD,FIELD,ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = PhoneNumberValidator.class)
@Documented
public @interface PhoneNumber {
    String message() default "{validator.errpr}";
//    Class<?>[] groups default{};
    public abstract Class<? extends Payload>[] payload() default {};

}
