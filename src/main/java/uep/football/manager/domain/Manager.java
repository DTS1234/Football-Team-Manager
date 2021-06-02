package uep.football.manager.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @date 02.06.2021
 */
@Entity
@Data
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;
    private String firstName;
    private String lastName;

    private String username;
    private String password;

    @OneToOne(mappedBy = "manager")
    private Club club;

}
