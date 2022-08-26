package academy.homework01.airliner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BombardierTest {

    @Test
    void testConstructor() {
        Vendor vendor = Vendor.BOMBARDIER;
        Bombardier bombardier = new Bombardier(Airliner.getId(), vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());
        assertNotNull(bombardier);
    }

}
