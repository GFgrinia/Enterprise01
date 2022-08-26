package academy.homework01.airliner;

/**
 * Enumeration of available Airliner manufacturers and Airliner's parameters
 */
public enum Vendor {

    AIRBUS(2700, 6150, 150),
    BOEING(2180, 6230, 149),
    EMBRAER(1390, 2100, 20),
    BOMBARDIER(920, 5670, 9);

    private final int fuelConsumption;
    private final int maxDistance;
    private final int passengerAmount;

    Vendor(int fuelConsumption, int maxDistance, int passengerAmount) {
        this.fuelConsumption = fuelConsumption;
        this.maxDistance = maxDistance;
        this.passengerAmount = passengerAmount;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public int getPassengerAmount() {
        return passengerAmount;
    }
}
