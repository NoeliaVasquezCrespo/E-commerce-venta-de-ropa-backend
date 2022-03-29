package ucb.edu.bo.sis.ventaropa.dto;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private Integer userId;
    private String messege;

    public JwtResponse(String jwttoken, Integer userId, String messege) {
        this.jwttoken = jwttoken;
        this.userId = userId;
        this.messege = messege;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwttoken='" + jwttoken + '\'' +
                ", userId=" + userId +
                ", messege='" + messege + '\'' +
                '}';
    }
}