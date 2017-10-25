package local.my.temp.dto;

import local.my.temp.enums.ClientType;
import local.my.temp.validation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

/**
 * @author Vitaly Moskalik
 * created on 24.10.2017
 */
@Getter
@Setter
@ToString
@GroupSequence({CustomValidationGroup.class, ClientDTO.class})
@ClientConstraint(groups = CustomValidationGroup.class)
//@GroupSequenceProvider(value = ClientGroupSequenceProvider.class)
public class ClientDTO {
    @NotBlank(groups = {ClientValidationGroup.class, DudeValidationGroup.class})
    private String name;
    @NotBlank(groups = ClientValidationGroup.class)
    private String surname;
    @NotBlank(groups = ClientValidationGroup.class)
    private String patronymic;
    @NotNull(groups = {ClientValidationGroup.class, DudeValidationGroup.class})
    private ClientType type;
}
