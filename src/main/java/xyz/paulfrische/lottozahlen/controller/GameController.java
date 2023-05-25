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
        List<Short> badNumbers = List.of((short)0, (short)0, (short)0, (short)0, (short)0, (short)0);

        String numbers = "";
        for (short number : classic.generateNumbers(badNumbers)) {
            numbers += " " + number;
        }

        model.addAttribute("game", "Classic");
        model.addAttribute("numbers", numbers);
        model.addAttribute("bad", badNumbers);
        System.out.println(badNumbers);
        return "game";
    }

    @PostMapping("/classic")
    public String classicPost(@ModelAttribute("numbers") NumbersRequestBody wrapper, Model model) {
        List<Short> badNumbers = List.of((short)0, (short)0, (short)0, (short)0, (short)0, (short)0);
        if (wrapper != null) {
            badNumbers = new ArrayList<>();
            badNumbers.add(wrapper.getNumber1());
            badNumbers.add(wrapper.getNumber2());
            badNumbers.add(wrapper.getNumber3());
            badNumbers.add(wrapper.getNumber4());
            badNumbers.add(wrapper.getNumber5());
            badNumbers.add(wrapper.getNumber6());
            System.out.println(wrapper.toString());
        }

        String numbers = "";
        for (short number : classic.generateNumbers(badNumbers)) {
            numbers += " " + number;
        }

        model.addAttribute("game", "Classic");
        model.addAttribute("numbers", numbers);
        model.addAttribute("bad", badNumbers);
        System.out.println(badNumbers);
        return "game";
    }

    @RequestMapping("/eurojackpot")
    public String eurojackpot(Model model) {
        model.addAttribute("game", "Eurojackpot");
        return "game";
    }
}
