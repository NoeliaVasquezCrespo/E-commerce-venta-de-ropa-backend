package ucb.edu.bo.sis.ventaropa.dto;

import java.io.Serializable;

public class AuthRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String correo;
    private String password;

    public AuthRequest() {
    }

    public AuthRequest(String username, String password) {
        this.correo = username;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String username) {
        this.correo = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
