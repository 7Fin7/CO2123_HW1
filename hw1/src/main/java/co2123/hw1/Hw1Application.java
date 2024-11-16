package co2123.hw1;

import co2123.hw1.domain.Market;
import co2123.hw1.domain.Stall;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Hw1Application.class, args);
    }

    public static List<Market> markets;

    @Override
    public void run(String... args) throws Exception {
    // Creates and populates sample data for markets and stalls

        markets = new ArrayList<>();

        // First Market
        Market m = new Market();
        m.setId(1);
        m.setName("Christmas");
        m.setLocation("London");

        List<Stall> stallsList = new ArrayList<>();	// List to hold stalls for this market

        // First Stall for Market
        Stall stall1 = new Stall();
        stall1.setHours(3);
        stall1.setOwner("Santa");
        stall1.setProducts("Flowers");
        stall1.setType("Products");
        stallsList.add(stall1);

        // Second Stall for Market
        Stall stall2 = new Stall();
        stall2.setHours(10);
        stall2.setOwner("Rudolph");
        stall2.setProducts("Vegetables");
        stall2.setType("Food");
        stallsList.add(stall2);

        // Associate stalls with market
        m.setStalls(stallsList);

        markets.add(m);
    }
}
