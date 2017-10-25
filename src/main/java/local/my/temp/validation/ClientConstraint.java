package local.my.temp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Vitaly Moskalik
 * created on 24.10.2017
 */
@Target({TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ClientValidator.class)
public @interface ClientConstraint {
    String message() default "ClientConstraint default message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
