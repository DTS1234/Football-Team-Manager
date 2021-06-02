package uep.football.manager.service.auth;

import lombok.Data;

/**
 * @date 02.06.2021
 */
@Data
public class LoginDTO {

    private String username;
    private String password;
    private String clubName;

}
