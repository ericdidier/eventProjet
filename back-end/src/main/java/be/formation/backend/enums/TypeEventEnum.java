package be.formation.backend.enums;

/**
 * Classe qui permet de definir le different type Event.
 */
public enum TypeEventEnum {

    MUSIC("MUSIC"),
    THEATRE("THEATRE"),
    COMEDY("COMEDY"),
    FESTIVALS("FESTIVALS");
    private final String value;

    TypeEventEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public static TypeEventEnum fromTypeEnum(String data) {
        for (TypeEventEnum type : values()) {
            if (type.value.equals(data)) {
                return type;
            }
        }
        return null;
    }
}
