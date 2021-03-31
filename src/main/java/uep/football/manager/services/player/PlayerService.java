package uep.football.manager.services.player;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Player;
import uep.football.manager.repositories.PlayerRepository;
import uep.football.manager.services.player.PlayerNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author akazmierczak
 * @date 31.03.2021
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

    private final PlayerRepository playerRepository;

    public ModelAndView addPlayer(Player player)
    {
        playerRepository.save(player);
        List<Player> playerList = playerRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("players");
        modelAndView.addObject("players", playerList);

        return modelAndView;
    }

    public ModelAndView removePlayer(Long id)
    {
        Optional<Player> playerOptional = playerRepository.findById(id);
        playerOptional.ifPresentOrElse(playerRepository::delete, PlayerNotFoundException::new);

        List<Player> listAfterRemovingPlayer = playerRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("players");
        modelAndView.addObject("players", listAfterRemovingPlayer);

        return modelAndView;
    }

    public ModelAndView allPlayersView()
    {
        ModelAndView modelAndView = new ModelAndView("players");
        modelAndView.addObject("players", playerRepository.findAll());
        return modelAndView;
    }



}
