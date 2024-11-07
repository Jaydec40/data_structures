import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Houseproj<T> {
    private Map<T, List<String>> rooms;
    private String address;

    public Houseproj(String address) {
        this.address = address;
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

    public static void main(String[] args) {
        House<String> myHouse = new House<>("123 Main Street");
        myHouse.addRoom("Living room");
        myHouse.addRoom("Kitchen");
        myHouse.addRoom("Bathroom");

        myHouse.add("Living room", "TV");
        myHouse.add("Living room", "Sofa");
        myHouse.add("Kitchen", "Fridge");
        myHouse.add("Bathroom", "Towels");

        System.out.println("My house at " + myHouse.getAddress() + " has these rooms: " + myHouse.rooms.keySet());

        List<String> livingRoomItems = myHouse.find("Living room");
        System.out.println("Items in living room: " + livingRoomItems);

        List<String> kitchenItems = myHouse.find("Kitchen");
        System.out.println("Items in kitchen: " + kitchenItems);
    }
}
