package uep.football.manager.service.auth;

/**
 * @date 02.06.2021
 */
public class LoginState {

    public Long id;
    public boolean loggedIn;
    public boolean isManger;
    public boolean isCoach;

    public void logout()
    {
        id = -1L;
        loggedIn = false;
        isManger = false;
        isCoach = false;
    }

}
