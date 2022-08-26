package academy.homework01.airliner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmbraerTest {

    @Test
    void testConstructor() {
        Vendor vendor = Vendor.EMBRAER;
        Embraer embraer = new Embraer(Airliner.getId(), vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());
        assertNotNull(embraer);
    }


}
