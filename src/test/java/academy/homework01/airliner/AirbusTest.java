package academy.homework01.airliner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AirbusTest {

    @Test
    void testConstructor() {
        Vendor vendor = Vendor.AIRBUS;
        Airbus airbus = new Airbus(Airliner.getId(), vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());
        assertNotNull(airbus);
    }


}
