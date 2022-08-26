package academy.homework01.company;

import academy.homework01.airliner.Airliner;
import academy.homework01.airliner.Vendor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class represents an AirCompany  to store Airliner objects and provides
 * several functions to user such as add new Airliner or
 * view list of all Airliners belongs to company
 * @author Yury Hrytsuk
 * @version 1.0
 */
public class AirCompany {

    // List of all airliners belong to this air company
    private final List<Airliner> airlinerList;
    private final String name;


    /**
     * AirCompany Constructor with varArgs...
     * @param name  Chosen name of AirCompany
     * @param vendors Chosen Manufacturer for Airliners
     */
    public AirCompany(String name, Vendor... vendors) {
        this.name = name;
        this.airlinerList = new ArrayList<>();
        for (Vendor vendor : vendors) {
            airlinerList.add(Airliner.addNewAirliner(vendor));
        }
    }


    /**
     * Returns AirCompany's name
     * @return Returns simple AirCompany's name chosen during creation
     */
    public String getName() {
        return name;
    }


    /**
     * Returns all Airliner belong to AirCompany
     * @return List of Airliners
     */
    public List<Airliner> getAirlinerList() {
        return airlinerList;
    }


    /**
     * Adds new Airliner to AirCompany
     * @param vendor Manufacturer of added Airliner
     */
    public void addAirliner(Vendor vendor) {
        airlinerList.add(Airliner.addNewAirliner(vendor));
    }


    /**
     * Overridden method returns AirCompany's name with word "AirCompany"
     * @return returns AirCompany's name with word "AirCompany"
     */
    @Override
    public String toString() {
        return "AirCompany{" + name + '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCompany that = (AirCompany) o;
        return Objects.equals(airlinerList, that.airlinerList) && Objects.equals(name, that.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(airlinerList, name);
    }


    /**
     * Sum all Passengers
     * @return Sum of all Passengers in all AirCompany's Airliners
     * @deprecated Use AirCompany.getAirlinerList() and iterator as Airliner.getPassengersAmount() instead
     */
    @Deprecated
    public int getSummaryPassengers() {
        int result = 0;

        for (Airliner airliner : airlinerList) {
            result += airliner.getPassengerAmount();
        }

        return result;
    }


}
