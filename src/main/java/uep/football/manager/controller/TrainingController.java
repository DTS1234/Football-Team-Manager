package uep.football.manager.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uep.football.manager.domain.PlayerList;
import uep.football.manager.domain.Training;
import uep.football.manager.repositories.TrainingRepository;
import uep.football.manager.service.training.TrainingAttendanceService;
import uep.football.manager.service.training.TrainingService;

import java.util.List;

/**
 * Controller for trainings.
 */
@Controller
@RequestMapping("trainings")
@RequiredArgsConstructor
@Slf4j
public class TrainingController {

    private final TrainingRepository trainingRepository;
    private final TrainingService trainingService;
    private final TrainingAttendanceService trainingAttendanceService;

    @RequestMapping
    public ModelAndView trainingsView()
    {
        List<Training> trainings = trainingRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("trainings");
        modelAndView.addObject("trainings", trainings);
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addTraining(@ModelAttribute Training training) {
        return trainingService.addTraining(training);
    }

    @GetMapping("/add")
    public ModelAndView trainingForm() {
        ModelAndView modelAndView = new ModelAndView("add_training");
        modelAndView.addObject("training", new Training());
        return modelAndView;
    }

    @RequestMapping("/{id}/remove")
    public ModelAndView removePlayer(@PathVariable Long id) {
        return trainingService.removeTraining(id);
    }

    @RequestMapping("/{id}/attendance")
    public ModelAndView viewAttendance(@PathVariable Long id) {
        return trainingAttendanceService.viewAttendance(id);
    }

    @GetMapping("/{id}/attendance/add")
    public ModelAndView addPlayerAttendanceForm(@PathVariable Long id)
    {
        return trainingAttendanceService.addAttendanceForm(id);
    }

    @PostMapping("/{id}/attendance/add")
    public ModelAndView addPlayerToAttendanceListAction(@PathVariable Long id, @ModelAttribute PlayerList playersToBeAdded) {
        return trainingAttendanceService.addPlayersAttendanceAction(playersToBeAdded, id);
    }

}
