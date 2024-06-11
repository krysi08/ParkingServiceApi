package com.example.parkingserviceapi;

import com.example.parkingserviceapi.fee.PriceList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PriceListTest {

    private PriceList priceList;

    public PriceListTest(PriceList priceList) {
        this.priceList = priceList;
    }

    @Test
    public void settle_parking_cost_till_10_minutes() {

        double calculatedFee = priceList.settleCostsParking(5);

        assertEquals(0, calculatedFee);
    }

    @Test
    public void settle_parking_cost_till_one_hour() {

        double calculatedFee = priceList.settleCostsParking(50);

        assertEquals(5, calculatedFee);
    }

    @Test
    public void settle_parking_cost_till_four_hour() {

        double calculatedFee = priceList.settleCostsParking(180);

        assertEquals(15, calculatedFee);
    }

    @Test
    public void settle_parking_cost_over_four_hour() {

        double calculatedFee = priceList.settleCostsParking(300);

        assertEquals(20, calculatedFee);
    }
}
