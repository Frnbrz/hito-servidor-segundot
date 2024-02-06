package spring.francisco.shared;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private final String turnoDescripcion;

    Role(String s) {
        this.turnoDescripcion = s;
    }
    public String getTurnoDescripcion() {
        return turnoDescripcion;
    }

    public static Role getRole(String role) {
        for (Role r : Role.values()) {
            if (r.getTurnoDescripcion().equals(role)) {
                return r;
            }
        }
        return null;
    }
}
