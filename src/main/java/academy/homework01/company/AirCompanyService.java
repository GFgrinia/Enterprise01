package academy.homework01.company;

import academy.homework01.airliner.Airliner;
import academy.homework01.airliner.Vendor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AirCompanyService implements CompanyService {

    public AirCompany createAirCompany (String name) {
        return new AirCompany(name);
    }


    public void addAirliner (AirCompany airCompany, Vendor... vendors) {
        for (Vendor vendor : vendors) {
            airCompany.addAirliner(vendor);
        }
    }


    public int getPassengersSummary (AirCompany airCompany) {
        return airCompany.getAirlinerList().stream()
                .mapToInt(Airliner::getPassengerAmount).sum();

    }


    public List<Airliner> getSpecificFuelConsumption(AirCompany airCompany, int min, int max) {
        return airCompany.getAirlinerList().stream()
                .filter(airliner -> airliner.getFuelConsumption() < max)
                .filter(airliner -> airliner.getFuelConsumption() > min)
                .collect(Collectors.toList());
    }


    public List<Airliner> getSortedListByDistance (AirCompany airCompany) {
        return airCompany.getAirlinerList().stream()
                .sorted(Comparator.comparing(Airliner::getMaxDistance).reversed())
                .collect(Collectors.toList());

    }
}
