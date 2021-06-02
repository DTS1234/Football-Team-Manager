package uep.football.manager.service.auth;

/**
 * @date 02.06.2021
 */
public class BadCredentialsPassed extends RuntimeException {

    public BadCredentialsPassed() {
    }

    public BadCredentialsPassed(String message) {
        super(message);
    }
}
