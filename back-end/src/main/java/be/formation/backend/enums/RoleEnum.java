package be.formation.backend.enums;

/**
 *
 */
public enum RoleEnum {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    WORKER("ROLE_WORKER"),
    GUEST("ROLE_GUEST");

    private final String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
