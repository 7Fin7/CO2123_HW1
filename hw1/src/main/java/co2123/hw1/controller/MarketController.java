package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Market;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class MarketController {

    @InitBinder
    public void initBinder(WebDataBinder binder) { binder.addValidators(new MarketValidator()); }

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
    public String addMarket(@Valid @ModelAttribute Market market, BindingResult bindingResult) {
        // On error return
        if (bindingResult.hasErrors()) {
            return "markets/form";
        }
        Hw1Application.markets.add(market);
        return "redirect:/markets";
    }

}
