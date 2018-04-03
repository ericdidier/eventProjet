package be.formation.backend.converter;

import be.formation.backend.enums.SendingModeEnum;
import be.formation.backend.enums.TypeEventEnum;
import be.formation.backend.utils.enums.EnumUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Convertisseur JPA qui associe une {@link be.formation.backend.model.entity.Booking ) ? une colonne DB {@link String}.
 * Created by eric.nyandwi .
 */
@Converter(autoApply = true)
public class TypeEventConverter implements AttributeConverter<TypeEventEnum, String> {

    @Override
    public String convertToDatabaseColumn(TypeEventEnum typeEventEnum) {
        return typeEventEnum != null ? typeEventEnum.getValue() : null;
    }

    @Override
    public TypeEventEnum convertToEntityAttribute(String data) {
        return  data!= null ? TypeEventEnum.fromTypeEnum(data) : null;
    }
}
