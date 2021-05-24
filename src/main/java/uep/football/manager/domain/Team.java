package uep.football.manager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @date 17.05.2021
 */
@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    private String name;

    private Long gp; // games played
    private Long w; // wins
    private Long d; // draws
    private Long l; // lost
    private Long gs; // goals scored
    private Long gl; // goals lost
    private Long pts; // points

}
