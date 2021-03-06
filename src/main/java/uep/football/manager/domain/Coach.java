package uep.football.manager.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coachId;
    private String firstName;
    private String lastName;

    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club;

}
