package xyz.paulfrische.lottozahlen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
    @RequestMapping("/classic")
    public String classic(Model model) {
        return "classic";
    }

    @RequestMapping("/eurojackpot")
    public String eurojackpot(Model model) {
        model.addAttribute("game", "Eurojackpot");
        return "eurojackpot";
    }
}
