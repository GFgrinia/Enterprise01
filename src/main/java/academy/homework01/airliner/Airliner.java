package academy.homework01.airliner;

import java.util.Objects;

abstract public class Airliner implements PassengerTransportable {

    // each airliner has unique ID and there is no airliner with id = 0
    private static int id;

    protected String name;
    protected int passengerAmount;
    protected int maxDistance;
    protected int fuelConsumption;


    public static Airliner addNewAirliner(Vendor vendor) {
        switch (vendor) {
            case AIRBUS:
                return new Airbus(++id,vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());
            case BOEING:
                return new Boeing(++id,vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());
            case EMBRAER:
                return new Embraer(++id,vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());
            case BOMBARDIER:
                return new Bombardier(++id,vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());
            default:
                return null;
        }

    }


    public int getPassengerAmount() {
        return this.passengerAmount;
    }

    public int getMaxDistance() {
        return this.maxDistance;
    }

    public int getFuelConsumption() {
        return this.fuelConsumption;
    }

    static public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airliner airliner = (Airliner) o;
        return passengerAmount == airliner.passengerAmount && maxDistance == airliner.maxDistance && fuelConsumption == airliner.fuelConsumption && name.equals(airliner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passengerAmount, maxDistance, fuelConsumption);
    }
}
