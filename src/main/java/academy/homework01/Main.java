package academy.homework01;


import academy.homework01.airliner.Airliner;
import academy.homework01.airliner.Vendor;
import academy.homework01.company.AirCompany;
import academy.homework01.company.AirCompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class logs result of given exercises (#9)
 */
public class Main {
    /*
    9.	Авиакомпания.
              Определить иерархию самолетов.
              Создать авиакомпанию.
              Посчитать общую вместимость и грузоподъемность.
              Провести сортировку самолетов компании по дальности полета.
              Найти самолет в компании, соответствующий заданному диапазону параметров потребления горючего.
     */

    static final Logger log = LogManager.getLogger();
    static final String COMPANY_NAME = "FlyJava LTD";
    static final int HIGH_FUEL_CONSUMPTION = 1000;
    static final int LOW_FUEL_CONSUMPTION = 213;

    public static void main(String[] args) {
        AirCompanyService airCompanyService =  new AirCompanyService();

        // creating company
        AirCompany airCompany = airCompanyService.createAirCompany(COMPANY_NAME);
        log.info(airCompany.getName() + " created....");


        // adding airliners
        airCompanyService.addAirliner(airCompany, Vendor.AIRBUS, Vendor.BOMBARDIER, Vendor.BOEING, Vendor.EMBRAER, Vendor.BOMBARDIER);


        // passengers summary
        int result = airCompanyService.getPassengersSummary(airCompany);
        log.info(String.format("%s - Passenger Summary - %d.", airCompany.getName(), result));


        // list of specific fuel consumption
        List<Airliner> fuelConsumptionList = airCompanyService.getSpecificFuelConsumption(airCompany, LOW_FUEL_CONSUMPTION, HIGH_FUEL_CONSUMPTION);
        log.info(String.format("Airliners with Fuel Consumption from %d to %d:%s", LOW_FUEL_CONSUMPTION, HIGH_FUEL_CONSUMPTION, fuelConsumptionList));


        // sorted list by MaxDistance (ascending)
        List<Airliner> sortedDistanceList = airCompanyService.getSortedListByDistance(airCompany);
        log.info("Airliners by Max Distance (ascending):" + sortedDistanceList);
    }


}
