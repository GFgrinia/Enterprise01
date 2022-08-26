package academy.homework01.company;

import academy.homework01.airliner.Airliner;
import academy.homework01.airliner.Vendor;

import java.util.List;


public interface CompanyService {
    AirCompany createAirCompany(String name);

    void addAirliner(AirCompany airCompany, Vendor... vendors);

    int getPassengersSummary(AirCompany airCompany);

    List<Airliner> getSpecificFuelConsumption(AirCompany airCompany, int min, int max);

    List<Airliner> getSortedListByDistance(AirCompany airCompany);
}
