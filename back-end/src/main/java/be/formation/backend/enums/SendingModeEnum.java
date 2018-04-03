package be.formation.backend.enums;

import be.formation.backend.utils.EnumValueForhrm;

public enum SendingModeEnum implements EnumValueForhrm<String> {

    /**
     * 0 = Par Email
     */
    SEND_FOR_EMAIL("0"),;

    SendingModeEnum(String value) {
        this.value = value;
    }

    private String value;

    @Override
    public String getValue() {
        return value;
    }


    public static SendingModeEnum fromSendingModelEnum(String data) {
        for (SendingModeEnum type : values()) {
            if (type.value.equals(data)) {
                return type;
            }
        }
        return null;
    }

}
