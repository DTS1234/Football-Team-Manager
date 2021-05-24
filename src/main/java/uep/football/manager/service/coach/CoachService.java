package uep.football.manager.service.coach;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uep.football.manager.controller.dto.SquadDTO;
import uep.football.manager.domain.Player;
import uep.football.manager.repositories.PlayerRepository;
import uep.football.manager.service.player.PlayerService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 24.05.2021
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class CoachService {

    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    public Player getPlayerByPosition(String position) {

        List<Player> allPLayers = playerService.getAllPLayers();

        List<Player> found = allPLayers.stream().filter(player -> player.getPosition().equals(position)).collect(Collectors.toList());

        if (found.isEmpty()) {
            return null;
        } else {
            return found.get(0);
        }

    }

    public void changePlayerPosition(Long playerId, String newPosition) {
        var player = playerService.getPLayerById(playerId);
        player.setPosition(newPosition);
        playerRepository.save(player);
    }

    public SquadDTO getSquad() {

        SquadDTO squadDTO = new SquadDTO();

        setGk(squadDTO);

        setRb(squadDTO);
        setCb1(squadDTO);
        setCb2(squadDTO);
        setLb(squadDTO);

        setLm(squadDTO);
        serCm1(squadDTO);
        setCm2(squadDTO);
        setRm(squadDTO);

        setSt1(squadDTO);
        setSt2(squadDTO);

        return squadDTO;
    }

    private void setSt1(SquadDTO squadDTO) {
        Player st1 = getPlayerByPosition("st1");
        if (st1 == null) {
            squadDTO.setSt1("ST");
        } else {
            squadDTO.setSt1(st1.getSurname());
        }
    }

    private void setSt2(SquadDTO squadDTO) {
        Player st2 = getPlayerByPosition("st2");
        if (st2 == null) {
            squadDTO.setSt2("ST");
        } else {
            squadDTO.setSt2(st2.getSurname());
        }
    }

    private void setRm(SquadDTO squadDTO) {
        Player rm = getPlayerByPosition("rm");
        if (rm == null) {
            squadDTO.setRm("RM");
        } else {
            squadDTO.setRm(rm.getSurname());
        }
    }

    private void setCm2(SquadDTO squadDTO) {
        Player cm2 = getPlayerByPosition("cm2");
        if (cm2 == null) {
            squadDTO.setCm2("CM");
        } else {
            squadDTO.setCm2(cm2.getSurname());
        }
    }

    private void serCm1(SquadDTO squadDTO) {
        Player cm1 = getPlayerByPosition("cm1");
        if (cm1 == null) {
            squadDTO.setCm1("CM");
        } else {
            squadDTO.setCm1(cm1.getSurname());
        }
    }

    private void setLm(SquadDTO squadDTO) {
        Player lm = getPlayerByPosition("lm");
        if (lm == null) {
            squadDTO.setLm("LM");
        } else {
            squadDTO.setLm(lm.getSurname());
        }
    }

    private void setGk(SquadDTO squadDTO) {
        Player gk = getPlayerByPosition("gk");
        if (gk == null) {
            squadDTO.setGk("GK");
        } else {
            squadDTO.setGk(gk.getSurname());
        }
    }

    private void setRb(SquadDTO squadDTO) {
        Player rb = getPlayerByPosition("rb");
        if (rb == null) {
            squadDTO.setRb("RB");
        } else {
            squadDTO.setRb(rb.getSurname());
        }
    }

    private void setCb1(SquadDTO squadDTO) {
        Player cb1 = getPlayerByPosition("cb1");
        if (cb1 == null) {
            squadDTO.setCb1("cb1");
        } else {
            squadDTO.setCb1(cb1.getSurname());
        }
    }

    private void setCb2(SquadDTO squadDTO) {
        Player cb2 = getPlayerByPosition("cb2");
        if (cb2 == null) {
            squadDTO.setCb2("cb2");
        } else {
            squadDTO.setCb2(cb2.getSurname());
        }
    }

    private void setLb(SquadDTO squadDTO) {
        Player lb = getPlayerByPosition("lb");
        if (lb == null) {
            squadDTO.setLb("lb");
        } else {
            squadDTO.setLb(lb.getSurname());
        }
    }


}
