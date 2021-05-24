package uep.football.manager.service.player;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Player;
import uep.football.manager.repositories.PlayerRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {

    private final PlayerRepository playerRepository;

    public ModelAndView addPlayer(Player player) {
        playerRepository.save(player);
        List<Player> playerList = playerRepository.findAll();

        var modelAndView = new ModelAndView("players");
        modelAndView.addObject("players", playerList);

        return modelAndView;
    }

    public ModelAndView removePlayer(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
        playerOptional.ifPresentOrElse(playerRepository::delete, PlayerNotFoundException::new);

        List<Player> listAfterRemovingPlayer = playerRepository.findAll();

        var modelAndView = new ModelAndView("players");
        modelAndView.addObject("players", listAfterRemovingPlayer);

        return modelAndView;
    }

    public ModelAndView allPlayersView() {
        var modelAndView = new ModelAndView("players");
        modelAndView.addObject("players", playerRepository.findAll());
        return modelAndView;
    }

    public List<Player> getAllPLayers() {
        return playerRepository.findAll();
    }

    public List<Player> getAllPlayersByGoals() {
        return playerRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(player -> -player.getGoalsScored()))
                .collect(Collectors.toList());
    }

    public List<Player> getAllPlayersByAssists() {
        return playerRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(player -> -player.getAssists()))
                .collect(Collectors.toList());
    }

    public List<Player> getAllPlayersByReds() {
        return playerRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(player -> -player.getRedCards()))
                .collect(Collectors.toList());
    }

    public List<Player> getAllPlayersByYellow() {
        return playerRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(player -> -player.getYellowCards()))
                .collect(Collectors.toList());
    }

    public List<Player> getAllPLayersByAttendance() {
        return playerRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(player -> -player.getTrainingsDone().stream().count()))
                .collect(Collectors.toList());
    }

    public Player getPLayerById(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);

        if (optionalPlayer.isPresent()) {
            return optionalPlayer.get();
        }

        throw new PlayerNotFoundException("Player with id " + id + " does not exist.");
    }

    public void updatePlayerDetails(Long id, Player playerWithUpdatedValues) {
        int age = playerWithUpdatedValues.getAge();
        int height = playerWithUpdatedValues.getHeight();
        int weight = playerWithUpdatedValues.getWeight();

        var playerToBeSaved = getPLayerById(id); // only update age, weight and height
        playerToBeSaved.setAge(age);
        playerToBeSaved.setWeight(weight);
        playerToBeSaved.setHeight(height);

        playerRepository.save(playerToBeSaved);

        log.info("data updated successfully !");
    }

    public void updatePlayerDetailsStats(Long id, Player playerWithUpdatedValues) {
        int assists = playerWithUpdatedValues.getAssists();
        int goalsScored = playerWithUpdatedValues.getGoalsScored();
        int redCards = playerWithUpdatedValues.getRedCards();
        int yellowCards = playerWithUpdatedValues.getYellowCards();
        double passPercentage = playerWithUpdatedValues.getPassPercentage();
        var interceptions = playerWithUpdatedValues.getInterceptions();
        var gamesPlayed = playerWithUpdatedValues.getGamesPlayed();

        var playerToBeSaved = getPLayerById(id); // only update age, weight and height
        playerToBeSaved.setAssists(assists);
        playerToBeSaved.setGoalsScored(goalsScored);
        playerToBeSaved.setRedCards(redCards);
        playerToBeSaved.setYellowCards(yellowCards);
        playerToBeSaved.setPassPercentage(passPercentage);
        playerToBeSaved.setInterceptions(interceptions);
        playerToBeSaved.setGamesPlayed(gamesPlayed);

        playerRepository.save(playerToBeSaved);

        log.info("statistics updated successfully !");
    }

    public void updateTestDetails(Long id, Player playerWithUpdatedValues) {
        double beepTest = playerWithUpdatedValues.getBeepTest();
        double sprint60m = playerWithUpdatedValues.getSprint60m();
        int pushUps = playerWithUpdatedValues.getPushUpsInRow();
        double verticalJump = playerWithUpdatedValues.getVerticalJump();

        var playerToBeSaved = getPLayerById(id); // only update age, weight and height
        playerToBeSaved.setBeepTest(beepTest);
        playerToBeSaved.setSprint60m(sprint60m);
        playerToBeSaved.setPushUpsInRow(pushUps);
        playerToBeSaved.setVerticalJump(verticalJump);
        playerToBeSaved.setLastTestDate(LocalDate.now());

        playerRepository.save(playerToBeSaved);

        log.info("tests updated successfully !");
    }
}



