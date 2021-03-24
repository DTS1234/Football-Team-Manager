package uep.football.manager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Player object.
 */
@Data
@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long playerId;
    private String name;
    private String surname;

}
