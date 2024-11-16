package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Market;
import co2123.hw1.domain.Stall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
public class StallController {

    @InitBinder
    public void initBinder(WebDataBinder binder) { binder.addValidators(new StallValidator()); }

    @RequestMapping("/stalls")
    public String showStalls(@RequestParam int market, Model model) {
        Market selectedMarket = null;

        for (Market m: Hw1Application.markets) {
            if (m.getId() == market) {
                selectedMarket = m;
                break;
            }
        }

        if (selectedMarket != null) {
            model.addAttribute("stalls", selectedMarket.getStalls());
            model.addAttribute("marketID", selectedMarket.getId());
        }
        return "stalls/list";
    }

    @RequestMapping("/newStall")
    public String newStall(Model model) {
        model.addAttribute("stall", new Stall());
        return "stalls/form";
    }

    @PostMapping("/addStall")
    public String addStall(@Valid @ModelAttribute Stall stall, BindingResult bindingResult, @RequestParam(defaultValue = "-1") int marketId) {

        // On error return
        if (bindingResult.hasErrors()) {
            return "stalls/form";
        }

        Market market = null;

        for (Market m : Hw1Application.markets) {
            if (m.getId() == marketId) {
                market = m;
                break;
            }
        }

        if (market != null) {
            market.getStalls().add(stall);
        }

        return "redirect:/markets";
    }
}
