package academy.homework01.company;

import academy.homework01.airliner.Airliner;
import academy.homework01.airliner.Vendor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AirCompanyServiceTest {

    @Test
    void testCreateAirCompany() {
        AirCompanyService airCompanyService =  new AirCompanyService();
        AirCompany airCompany = airCompanyService.createAirCompany("AirCompanyName");
        assertNotNull(airCompany);
    }


    @Test
    void testAddAirliner() {
        AirCompanyService airCompanyService =  new AirCompanyService();
        AirCompany airCompany = airCompanyService.createAirCompany("AirCompanyName");
        int beforeAdding = airCompany.getAirlinerList().size();
        airCompanyService.addAirliner(airCompany, Vendor.BOEING);

        assertTrue(airCompany.getAirlinerList().size() > beforeAdding);
    }


    @Test
    void testGetPassengersSummary() {
        AirCompanyService airCompanyService =  new AirCompanyService();

        AirCompany airCompany = airCompanyService.createAirCompany("AirCompanyName");
        airCompanyService.addAirliner(airCompany, Vendor.AIRBUS, Vendor.BOMBARDIER, Vendor.BOEING, Vendor.EMBRAER);

        List<Airliner> list = airCompany.getAirlinerList();
        int result = 0;

        for (Airliner airliner : list) {
            result += airliner.getPassengerAmount();
        }

        assertEquals(result, airCompanyService.getPassengersSummary(airCompany));
    }


    @Test
    void testGetSpecificFuelConsumption() {
        AirCompanyService airCompanyService =  new AirCompanyService();
        int min = 0;
        int max = 2000;
        AirCompany airCompany = airCompanyService.createAirCompany("AirCompanyName");
        airCompanyService.addAirliner(airCompany, Vendor.AIRBUS, Vendor.BOMBARDIER, Vendor.BOEING, Vendor.EMBRAER);

        List<Airliner> result = airCompanyService.getSpecificFuelConsumption(airCompany, min, max);
        List<Airliner> expected = new ArrayList<>();
        List<Airliner> list = airCompany.getAirlinerList();

        for (Airliner airliner : list) {
            if (airliner.getFuelConsumption() <= max && airliner.getFuelConsumption() >= min) {
                expected.add(airliner);
            }
        }

        assertEquals(expected,result);
    }


    @Test
    void testGetSortedListByDistance() {
        AirCompanyService airCompanyService =  new AirCompanyService();
        AirCompany airCompany = airCompanyService.createAirCompany("AirCompanyName");
        airCompanyService.addAirliner(airCompany, Vendor.AIRBUS, Vendor.BOMBARDIER, Vendor.BOEING, Vendor.EMBRAER);

        List<Airliner> result = airCompanyService.getSortedListByDistance(airCompany);
        int distance = result.get(0).getMaxDistance();
        boolean noError = true;

        for (Airliner airliner : result) {
            if (distance >= airliner.getMaxDistance()) {
                distance = airliner.getMaxDistance();
            } else {
                noError = false;
                break;
            }
        }

        assertTrue(noError);
    }



}
