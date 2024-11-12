package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarketController {

    @RequestMapping("/markets")
    public String showMarkets(Model model) {
        model.addAttribute("markets", Hw1Application.markets);
        return "markets/list";
    }

}
