package ucb.edu.bo.sis.ventaropa.dto;

import java.io.Serializable;

public class AuthRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String username;
    private String password;
    private Integer tipoUsuarioId;

    public AuthRequest() {
    }

    public AuthRequest(String username, String password, Integer tipoUsuarioId) {
        this.username = username;
        this.password = password;
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Integer tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tipoUsuarioId=" + tipoUsuarioId +
                '}';
    }
}
