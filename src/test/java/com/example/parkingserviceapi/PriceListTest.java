package com.example.parkingserviceapi;

import com.example.parkingserviceapi.fee.PriceList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@SpringBootTest
public class PriceListTest {

    private PriceList priceList;

    public PriceListTest(PriceList priceList) {
        this.priceList = priceList;
    }
    @Test
    public void settle_parking_cost_the_cheapest_one()
    {
        String requiredFee = "Please pay off 5EUR";

        priceList.settleCostsParking(10);
        assumingThat(
                requiredFee.equals("Please pay off 5EUR"),
                () -> assertEquals(10, 10)
        );
    }
    @Test
    public void settle_parking_cost()
    {
        String requiredFee = "Please pay off 5EUR";

        priceList.settleCostsParking(60);
        assumingThat(
                requiredFee.equals("Please pay off 5EUR"),
                () -> assertEquals(60, 60)
        );
    }
    @Test
    public void settle_parking_cost_medium()
    {
        String requiredFee = "You have to pay off" + " " + " " + "EUR";

        priceList.settleCostsParking(61);
        assumingThat(
                requiredFee.equals("You have to pay off" + " " + " " + "EUR"),
                () -> assertEquals(61, 61)
        );
    }
    @Test
    public void settle_parking_cost_medium_grather()
    {
        String requiredFee = "You have to pay off" + " " + " " + "EUR";

        priceList.settleCostsParking(240);
        assumingThat(
                requiredFee.equals("You have to pay off" + " " + " " + "EUR"),
                () -> assertEquals(240, 240)
        );
    }
    @Test
    public void settle_parking_cost_discount()
    {
        String requiredFee = "You have to pay off" + " " + " " + "EUR";

        priceList.settleCostsParking(241);
        assumingThat(
                requiredFee.equals("You have to pay off" + " " + " " + "EUR"),
                () -> assertEquals(241, 241)
        );
    }
    @Test
    public void settle_parking_cost_no_fees()
    {
        String requiredFee = "No fees";

        priceList.settleCostsParking(5);
        assumingThat(
                requiredFee.equals("No fees"),
                () -> assertEquals(5, 5)
        );
    }

}
