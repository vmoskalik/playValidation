package local.my.temp.validation;

import local.my.temp.dto.ClientDTO;
import local.my.temp.enums.ClientType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author Vitaly Moskalik
 * created on 24.10.2017
 */
@Component
@RequiredArgsConstructor
public class ClientValidator implements ConstraintValidator<ClientConstraint, ClientDTO> {

    private final LocalValidatorFactoryBean validator;

    @Override
    public void initialize(ClientConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(ClientDTO value, ConstraintValidatorContext context) {
        ClientType type = value.getType();
        Set<ConstraintViolation<ClientDTO>> constraintViolations;
//        BindingResult bindingResult = new BeanPropertyBindingResult(value, "ClientDTO");
        if (type == null || type == ClientType.CLIENT) {
            constraintViolations = validator.validate(value, ClientValidationGroup.class);
//            validator.validate(value, bindingResult, ClientValidationGroup.class);
        } else {
            constraintViolations = validator.validate(value, DudeValidationGroup.class);
        }

        if (constraintViolations.size() > 0) {
            context.disableDefaultConstraintViolation();
            constraintViolations.forEach(cv -> context
                    .buildConstraintViolationWithTemplate(cv.getMessage())
                    .addPropertyNode(String.valueOf(cv.getPropertyPath()))
                    .addConstraintViolation());
            return false;
        }
        return true;
    }
}
