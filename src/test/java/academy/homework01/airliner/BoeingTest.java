package academy.homework01.airliner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoeingTest {

    @Test
    void testConstructor() {
        Vendor vendor = Vendor.BOEING;
        Boeing boeing = new Boeing(Airliner.getId(), vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());
        assertNotNull(boeing);
    }

}
