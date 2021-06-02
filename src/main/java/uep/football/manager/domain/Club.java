package uep.football.manager.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @date 02.06.2021
 */
@Entity
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;
    @Column(unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToMany
    private List<Player> playerList;
    @OneToMany
    private List<News> news;

}
