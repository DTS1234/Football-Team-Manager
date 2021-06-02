package uep.football.manager.service.manager;

/**
 * @date 02.06.2021
 */
public class ManagerNotFoundException extends RuntimeException {
    public ManagerNotFoundException() {
    }

    public ManagerNotFoundException(String message) {
        super(message);
    }
}
