package uep.football.manager.service.training;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.Training;
import uep.football.manager.repositories.TrainingRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author akazmierczak
 * @date 31.03.2021
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public ModelAndView addTraining(Training training) {
        trainingRepository.save(training);
        List<Training> trainingsList = trainingRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("trainings");
        modelAndView.addObject("trainings", trainingsList);

        return modelAndView;
    }

    public ModelAndView removeTraining(Long id) {
        Optional<Training> trainingOptional = trainingRepository.findById(id);

        trainingOptional.ifPresentOrElse(trainingRepository::delete, TrainingNotFoundException::new);

        List<Training> trainingList = trainingRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("trainings");
        modelAndView.addObject("trainings", trainingList);

        return modelAndView;
    }

    public List<Training> getAllTrainings()
    {
        return trainingRepository.findAll();
    }


}
