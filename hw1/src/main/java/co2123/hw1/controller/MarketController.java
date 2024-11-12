package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Market;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarketController {

    @RequestMapping("/markets")
    public String showMarkets(Model model) {
        model.addAttribute("markets", Hw1Application.markets);
        return "markets/list";
    }

    @RequestMapping("/newMarket")
    public String newMarket(Model model) {
        model.addAttribute("market", new Market());
        return "markets/form";
    }

    @PostMapping("/addMarket")
    public String submitNewMarket(@ModelAttribute Market market) {
        Hw1Application.markets.add(market);
        return "redirect:/markets";
    }

}
