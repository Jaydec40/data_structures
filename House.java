import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class House<T> {
    private Map<T, List<String>> rooms;
    private String address;
    private int numBedrooms;
    private int numBathrooms;
    private boolean hasGarage;

    public House(String address, int numBedrooms, int numBathrooms, boolean hasGarage) {
        this.address = address;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.hasGarage = hasGarage;
        rooms = new HashMap<>();
    }

    public void addRoom(T room) {
        rooms.put(room, new ArrayList<>());
    }

    public void add(T room, String item) {
        List<String> items = rooms.get(room);
        if (items != null) {
            items.add(item);
        }
    }

    public List<String> find(T room) {
        return rooms.get(room);
    }

    public String getAddress() {
        return address;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public boolean hasGarage() {
        return hasGarage;
    }
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<House<String>> houses = new ArrayList<>();

    while (true) {
        System.out.print("Do you want to add a new house? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("no")) {
            break;
        }

        System.out.print("Enter the address of the house: ");
        String address = scanner.nextLine();
        System.out.print("Enter the number of bedrooms: ");
        int numBedrooms = scanner.nextInt();
        System.out.print("Enter the number of bathrooms: ");
        int numBathrooms = scanner.nextInt();
        System.out.print("Does the house have a garage? (true/false): ");
        boolean hasGarage = scanner.nextBoolean();
        scanner.nextLine();

        House<String> house = new House<>(address, numBedrooms, numBathrooms, hasGarage);
        house.addRoom("Living room");
        house.addRoom("Kitchen");
        house.addRoom("Bathroom");

        house.add("Living room", "TV");
        house.add("Living room", "Sofa");
        house.add("Kitchen", "Fridge");
        house.add("Bathroom", "Towels");

        houses.add(house);
    }

    while (true) {
        System.out.print("Do you want to search for a house? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("no")) {
            break;
        }

        System.out.print("Enter the address of the house you want to search: ");
        String searchAddress = scanner.nextLine();

        House<String> searchedHouse = searchHouse(houses, searchAddress);

        if (searchedHouse != null) {
            System.out.println("House found at " + searchedHouse.getAddress());
            System.out.println("Number of bedrooms: " + searchedHouse.getNumBedrooms());
            System.out.println("Number of bathrooms: " + searchedHouse.getNumBathrooms());
            System.out.println("Has a garage: " + (searchedHouse.hasGarage() ? "Yes" : "No"));

            List<String> livingRoomItems = searchedHouse.find("Living room");
            System.out.println("Living room items: " + livingRoomItems);

            List<String> kitchenItems = searchedHouse.find("Kitchen");
            System.out.println("Kitchen items: " + kitchenItems);

            List<String> bathroomItems = searchedHouse.find("Bathroom");
            System.out.println("Bathroom items: " + bathroomItems);
        } else {
            System.out.println("House not found.");
        }
    }
}

public static House<String> searchHouse(List<House<String>> houses, String address) {
    for (House<String> house : houses) {
        if (house.getAddress().equalsIgnoreCase(address)) {
            return house;
        }
    }

    return null;
}
}
