package be.formation.backend.converter;

import be.formation.backend.enums.SendingModeEnum;
import be.formation.backend.utils.enums.EnumUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convertisseur JPA qui associe une {@link be.formation.backend.model.entity.Booking ) ? une colonne DB {@link Integer}.
 * Created by eric.nyandwi .
 */
@Converter(autoApply = true)
public class SendingModelConverter  implements AttributeConverter<SendingModeEnum, String> {


    @Override
    public String convertToDatabaseColumn(SendingModeEnum sendingModeEnum) {
       return sendingModeEnum != null ? sendingModeEnum.getValue() : null;
    }

    @Override
    public SendingModeEnum convertToEntityAttribute(String data) {
        return data != null ? SendingModeEnum.fromSendingModelEnum(data) : null;
    }
}
