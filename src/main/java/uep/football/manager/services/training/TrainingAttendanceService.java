package uep.football.manager.services.training;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Player;
import uep.football.manager.domain.PlayerList;
import uep.football.manager.domain.Training;
import uep.football.manager.repositories.PlayerRepository;
import uep.football.manager.repositories.TrainingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author akazmierczak
 * @date 31.03.2021
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingAttendanceService {

    private final TrainingRepository trainingRepository;
    private final PlayerRepository playerRepository;

    public ModelAndView viewAttendance(Long trainingId)
    {
        Optional<Training> trainingOptional = trainingRepository.findById(trainingId);

        if (trainingOptional.isPresent()) {
            Training training = trainingOptional.get();
            ModelAndView modelAndView = new ModelAndView("view_attendance");
            modelAndView.addObject("players", training.getPlayers());
            modelAndView.addObject("training", training);
            return modelAndView;
        }
        throw new IllegalArgumentException("training with id " + trainingId + " does not exist.");
    }

    public ModelAndView addAttendanceForm(Long trainingId)
    {
        ModelAndView modelAndView = new ModelAndView("add_player_attendance");

        List<Player> allPossiblePlayers = playerRepository.findAll();
        Optional<Training> optionalTraining = trainingRepository.findById(trainingId);

        if (optionalTraining.isPresent())
        {
            Training training = optionalTraining.get();
            List<Player> playersCurrentlyAttending = training.getPlayers();
            List<Player> possiblePlayers = allPossiblePlayers
                    .stream()
                    .filter(player -> !playersCurrentlyAttending.contains(player))
                    .collect(Collectors.toList());

            PlayerList playerList = new PlayerList();
            playerList.setPlayerList(possiblePlayers);

            modelAndView.addObject("players", playerList);
            modelAndView.addObject("predefinedPlayers", playerList.getPlayerList());
            modelAndView.addObject("training", training);

            return modelAndView;
        }

        throw new TrainingNotFoundException();

    }

    public ModelAndView addPlayersAttendanceAction(PlayerList playersToBeAdded, Long trainingId)
    {
        ModelAndView modelAndView = new ModelAndView("view_attendance");

        if (playersToBeAdded.getPlayerList() == null)
        {
            throw new IllegalArgumentException("players are null !");
        }

        Optional<Training> optionalTraining = trainingRepository.findById(trainingId);

        if (optionalTraining.isPresent()) {
            Training training = optionalTraining.get();
            List<Player> attendance = training.getPlayers();

            attendance.addAll(playersToBeAdded.getPlayerList());
            training.setPlayers(attendance);
            trainingRepository.save(training);

            modelAndView.addObject("training", training);
            modelAndView.addObject("players", training.getPlayers());

        } else {
            throw new TrainingNotFoundException("No training with id " + trainingId + " !");
        }

        return modelAndView;
    }
}
