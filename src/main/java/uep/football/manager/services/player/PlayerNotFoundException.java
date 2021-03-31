package uep.football.manager.services.player;

/**
 * @author akazmierczak
 * @date 31.03.2021
 */
public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException() {
        super();
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }
}
