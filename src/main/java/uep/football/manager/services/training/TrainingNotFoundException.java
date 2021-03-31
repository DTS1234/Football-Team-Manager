package uep.football.manager.services.training;

/**
 * @author akazmierczak
 * @date 31.03.2021
 */
public class TrainingNotFoundException extends RuntimeException {

    public TrainingNotFoundException() {
        super();
    }

    public TrainingNotFoundException(String message) {
        super(message);
    }
}
