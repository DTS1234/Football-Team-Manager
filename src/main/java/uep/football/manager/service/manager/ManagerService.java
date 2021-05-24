package uep.football.manager.service.manager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uep.football.manager.repositories.PlayerRepository;
import uep.football.manager.service.player.PlayerNotFoundException;

/**
 * @date 24.05.2021
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ManagerService {

    private final PlayerRepository playerRepository;

    public void setPlayerInjured(Long playerId, Boolean injured)
    {
        var player = playerRepository.findById(playerId).orElseThrow(PlayerNotFoundException::new);
        player.setInjured(injured);
        playerRepository.save(player);
    }

    public void setPlayerSuspended(Long playerId, Boolean suspended)
    {
        var player = playerRepository.findById(playerId).orElseThrow(PlayerNotFoundException::new);
        player.setSuspended(suspended);
        playerRepository.save(player);
    }

}
