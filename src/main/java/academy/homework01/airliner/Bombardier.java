package academy.homework01.airliner;

public class Bombardier extends Airliner {
    public Bombardier(int id, int fuelConsumption, int maxDistance, int passengerAmount) {
        this.fuelConsumption = fuelConsumption;
        this.maxDistance = maxDistance;
        this.passengerAmount = passengerAmount;
        this.name = "Bombardier [BMB-" + String.format("%03d]", id);
    }

    @Override
    public String toString() {
        return name;
    }
}
