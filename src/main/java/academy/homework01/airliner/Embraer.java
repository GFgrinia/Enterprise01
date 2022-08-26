package academy.homework01.airliner;

public class Embraer extends Airliner {
    public Embraer(int id, int fuelConsumption, int maxDistance, int passengerAmount) {
        this.fuelConsumption = fuelConsumption;
        this.maxDistance = maxDistance;
        this.passengerAmount = passengerAmount;
        this.name = "Embraer [EMB-" + String.format("%03d]", id);
    }

    @Override
    public String toString() {
        return name;
    }
}
