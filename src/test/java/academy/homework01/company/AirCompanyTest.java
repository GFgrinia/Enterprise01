package academy.homework01.company;

import academy.homework01.airliner.Airbus;
import academy.homework01.airliner.Airliner;
import academy.homework01.airliner.Bombardier;
import academy.homework01.airliner.Vendor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class AirCompanyTest {

    @Test
    void testConstructor() {
        AirCompany airCompany;
        airCompany = new AirCompany("FlyJava LTD", Vendor.EMBRAER);

        assertNotNull(airCompany);
    }


    @Test
    void testGetAirlinerList() {

        int currentId = Airliner.getId();
        Vendor vendor = Vendor.BOMBARDIER;
        AirCompany airCompany = new AirCompany("FlyJava LTD", vendor, vendor);
        List<Airliner> list = new ArrayList<>();

        list.add(new Bombardier(currentId + 1, vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount()));
        list.add(new Bombardier(currentId + 2, vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount()));

        assertEquals(list, airCompany.getAirlinerList());
    }


    @Test
    void testAddAirliner() {
        int currentId = Airliner.getId();
        Vendor vendor = Vendor.AIRBUS;
        AirCompany airCompany = new AirCompany("FlyJava LTD");
        airCompany.addAirliner(vendor);
        Airliner airliner = new Airbus(currentId + 1, vendor.getFuelConsumption(), vendor.getMaxDistance(), vendor.getPassengerAmount());

        assertEquals(airliner, airCompany.getAirlinerList().get(0));
    }


    @Test
    void testGetSummaryPassengers() {
        Vendor vendor = Vendor.BOMBARDIER;
        AirCompany airCompany = new AirCompany("FlyJava LTD", vendor, vendor);

        assertEquals(Vendor.BOMBARDIER.getPassengerAmount() * 2, airCompany.getSummaryPassengers());
    }


    // Try the test with a lot of similar parameters
    @ParameterizedTest
    @MethodSource("testCompanyNameCases")
    void testCompanyName(String name, AirCompany airCompany) {
        assertEquals(name, airCompany.getName());
    }


    // Here we create steam of EXPECTED values
    // Method's name have to be the same according to @MethodSource
    static Stream<Arguments> testCompanyNameCases() {
        final Iterator<String> companyNames = Arrays.asList(
                "@",
                "FlyJava LTD",
                "CompanyName",
                "1234").iterator();

        return airCompanies()
                .map(c -> Arguments.of(companyNames.next(), c));
    }


    // And here we create steam of ACTUAL objects
    // Method's name have to be the same according to Iterator we use in our tests
    private static Stream<AirCompany> airCompanies() {
        return Stream.of(
                new AirCompany("@"),
                new AirCompany("FlyJava LTD"),
                new AirCompany("CompanyName"),
                new AirCompany("1234")
        );
    }


}
