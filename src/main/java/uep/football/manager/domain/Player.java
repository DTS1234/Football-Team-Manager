package uep.football.manager.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    private String name;
    private String surname;

    private int age;
    private int height;
    private int weight;

    private double sprint60m;
    private double verticalJump;
    private double beepTest;
    private int pushUpsInRow;
    private LocalDate lastTestDate;

    private int goalsScored;
    private int assists;
    private double passPercentage;
    private int interceptions;
    private int yellowCards;
    private int redCards;
    private int gamesPlayed;

    private String position;
    private boolean isInjured;
    private boolean isSuspended;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    private String password;
    private String username;

    @ManyToMany
    @JoinTable(name = "TRAINING_PLAYERS",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    private List<Training> trainingsDone;

}
