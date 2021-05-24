package uep.football.manager.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import uep.football.manager.common.ResultEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime date;
    private Integer goalsScored;
    private Integer goalsLost;
    private String guest;
    private String home;
    private ResultEnum result;

}
