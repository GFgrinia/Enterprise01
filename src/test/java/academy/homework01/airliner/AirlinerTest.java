package academy.homework01.airliner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirlinerTest {

    @Test
    void testAddNewAirliner() {
        Airliner airliner;
        airliner = Airliner.addNewAirliner(Vendor.BOEING);
        assertNotNull(airliner);
    }


    @Test
    void testAddNewAirliner2() {
        Airliner airliner = Airliner.addNewAirliner(Vendor.EMBRAER);
        assertEquals(Embraer.class, airliner.getClass());
    }


    @Test
    void testGetPassengerAmount() {
        Airliner airliner = Airliner.addNewAirliner(Vendor.AIRBUS);
        assert airliner != null;
        assertEquals(airliner.getPassengerAmount(), Vendor.AIRBUS.getPassengerAmount());
    }


    @Test
    void testGetMaxDistance() {
        Airliner airliner = Airliner.addNewAirliner(Vendor.EMBRAER);
        assertEquals(airliner.getMaxDistance(), Vendor.EMBRAER.getMaxDistance());
    }


    @Test
    void testGetFuelConsumption() {
        Airliner airliner = Airliner.addNewAirliner(Vendor.BOMBARDIER);
        assertEquals(airliner.getFuelConsumption(), Vendor.BOMBARDIER.getFuelConsumption());
    }
}
