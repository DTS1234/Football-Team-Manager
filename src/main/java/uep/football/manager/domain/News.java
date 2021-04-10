package uep.football.manager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author akazmierczak
 * @date 10.04.2021
 */
@Data
@Entity
public class News {

    @Id
    @GeneratedValue
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime dateTime;

}
