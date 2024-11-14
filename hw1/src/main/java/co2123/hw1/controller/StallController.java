package co2123.hw1.controller;

import co2123.hw1.Hw1Application;
import co2123.hw1.domain.Market;
import co2123.hw1.domain.Stall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StallController {

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
        }
        return "stalls/list";
    }

    @RequestMapping("/newStall")
    public String newMarket(Model model) {
        model.addAttribute("stall", new Stall());
        return "stalls/form";
    }

    @PostMapping("/addStall")
    public String submitNewMarket(@ModelAttribute Stall stall, @RequestParam int marketId) {
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
