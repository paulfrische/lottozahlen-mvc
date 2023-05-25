package xyz.paulfrische.lottozahlen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.paulfrische.lottozahlen.games.ClassicGame;
import xyz.paulfrische.lottozahlen.games.Eurojackpot;
import xyz.paulfrische.lottozahlen.wrappers.NumbersRequestBody;

@Controller
public class GameController {
    ClassicGame classic = new ClassicGame();
    Eurojackpot eurojackpot = new Eurojackpot();

    @GetMapping("/classic")
    public String classicGet(Model model) {
        List<Short> badNumbers = List.of((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        List<Short> numbers = classic.generateNumbers(badNumbers);

        model.addAttribute("numbers", numbers);
        model.addAttribute("bad", badNumbers);
        model.addAttribute("game", "Classic");
        return "game";
    }

    @PostMapping("/classic")
    public String classicPost(@ModelAttribute("numbers") NumbersRequestBody wrapper, Model model) {
        boolean warning = false;
        String message = "";
        List<Short> badNumbers = List.of((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);
        if (wrapper != null) {
            badNumbers = new ArrayList<>();
            badNumbers.add(wrapper.getNumber1());
            badNumbers.add(wrapper.getNumber2());
            badNumbers.add(wrapper.getNumber3());
            badNumbers.add(wrapper.getNumber4());
            badNumbers.add(wrapper.getNumber5());
            badNumbers.add(wrapper.getNumber6());
        }

        for (short number : badNumbers) {
            if (number > 49 || number < 0) {
                warning = true;
                message = "The number '" + number + "' is out of range (0-49)";
            }
        }

        List<Short> numbers = classic.generateNumbers(badNumbers);

        model.addAttribute("numbers", numbers);
        model.addAttribute("bad", badNumbers);
        model.addAttribute("game", "Classic");
        model.addAttribute("warning", warning);
        model.addAttribute("msg", message);
        return "game";
    }

    @GetMapping("/eurojackpot")
    public String eurojackpotGet(Model model) {
        List<Short> badNumbers = List.of((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);

        List<Short> numbers = eurojackpot.generateNumbers(badNumbers);

        model.addAttribute("numbers", numbers);
        model.addAttribute("bad", badNumbers);
        model.addAttribute("game", "Eurojackpot");
        return "game";
    }

    @PostMapping("/eurojackpot")
    public String eurojackpotPost(@ModelAttribute("numbers") NumbersRequestBody wrapper, Model model) {
        boolean warning = false;
        String message = "";

        List<Short> badNumbers = List.of((short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0);
        if (wrapper != null) {
            badNumbers = new ArrayList<>();
            badNumbers.add(wrapper.getNumber1());
            badNumbers.add(wrapper.getNumber2());
            badNumbers.add(wrapper.getNumber3());
            badNumbers.add(wrapper.getNumber4());
            badNumbers.add(wrapper.getNumber5());
            badNumbers.add(wrapper.getNumber6());
        }

        for (short number : badNumbers) {
            if (number > 49 || number < 0) {
                warning = true;
                message = "The number '" + number + "' is out of range (0-49)";
            }
        }

        List<Short> numbers = eurojackpot.generateNumbers(badNumbers);

        model.addAttribute("numbers", numbers);
        model.addAttribute("bad", badNumbers);
        model.addAttribute("game", "Eurojackpot");
        model.addAttribute("warning", warning);
        model.addAttribute("msg", message);
        return "game";
    }
}
