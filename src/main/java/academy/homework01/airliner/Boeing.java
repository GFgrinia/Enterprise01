package academy.homework01.airliner;

public class Boeing extends Airliner {
    public Boeing(int id, int fuelConsumption, int maxDistance, int passengerAmount) {
        this.fuelConsumption = fuelConsumption;
        this.maxDistance = maxDistance;
        this.passengerAmount = passengerAmount;
        this.name = "Boeing [BOE-" + String.format("%03d]", id);
    }

    @Override
    public String toString() {
        return name;
    }
}
