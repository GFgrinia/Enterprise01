package academy.homework01.airliner;

public class Airbus extends Airliner {
    public Airbus(int id, int fuelConsumption, int maxDistance, int passengerAmount) {
        this.fuelConsumption = fuelConsumption;
        this.maxDistance = maxDistance;
        this.passengerAmount = passengerAmount;
        this.name = "Airbus [ARB-" + String.format("%03d]", id);
    }

    @Override
    public String toString() {
        return name;
    }
}
