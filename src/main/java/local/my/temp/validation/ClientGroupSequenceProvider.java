package local.my.temp.validation;

import local.my.temp.dto.ClientDTO;
import local.my.temp.enums.ClientType;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vitaly Moskalik
 * created on 25.10.2017
 */
public class ClientGroupSequenceProvider implements DefaultGroupSequenceProvider<ClientDTO> {
    @Override
    public List<Class<?>> getValidationGroups(ClientDTO object) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        ClientType type = object.getType();
        if (type == null) {
            defaultGroupSequence.add(ClientValidationGroup.class);
            defaultGroupSequence.add(DudeValidationGroup.class);
        } else if (type == ClientType.CLIENT) {
            defaultGroupSequence.add(ClientValidationGroup.class);
        } else {
            defaultGroupSequence.add(DudeValidationGroup.class);
        }
        return defaultGroupSequence;
    }
}
