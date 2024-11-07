import javax.swing.JOptionPane;
import java.util.ArrayList;

public class GarageStorage {
  static final int CAPACITY = 15;
  
  static class StorageLocation {
    private int count;
    private ArrayList<String> objects;
    
    StorageLocation() {
      this.count = 0;
      this.objects = new ArrayList<>();
    }
    
    boolean isFull() {
      return count >= CAPACITY;
    }
    
    void addObject(String object) {
      if (!isFull()) {
        objects.add(object);
        count++;
      }
    }
    
    int getCount() {
      return count;
    }
    
    ArrayList<String> getObjects() {
      return objects;
    }
  }
  
  public static void main(String[] args) {
    StorageLocation cabinets = new StorageLocation();
    StorageLocation workBench = new StorageLocation();
    StorageLocation bins = new StorageLocation();
    
    boolean done = false;
    while (!done && cabinets.getCount() + workBench.getCount() + bins.getCount() < 45) {
      if (cabinets.getCount() >= CAPACITY - 3 || workBench.getCount() >= CAPACITY - 3 || bins.getCount() >= CAPACITY - 3) {
        JOptionPane.showMessageDialog(null, "You are running out of space in at least one of your storage locations.");
      }
      
      String object = JOptionPane.showInputDialog("What object would you like to store?");
      if (object == null) {
        break;
      }
      
      String location = JOptionPane.showInputDialog("Where do you want to store the object?\n1. Cabinets\n2. Work Bench\n3. Bins");
      if (location == null) {
        break;
      }
      switch (location) {
        case "1":
          if (cabinets.isFull()) {
            JOptionPane.showMessageDialog(null, "Cabinets are full.");
            break;
          }
          cabinets.addObject(object);
          break;
        case "2":
          if (workBench.isFull()) {
            JOptionPane.showMessageDialog(null, "Work bench is full.");
            break;
          }
          workBench.addObject(object);
          break;
        case "3":
          if (bins.isFull()) {
            JOptionPane.showMessageDialog(null, "Bins are full.");
            break;
          }
          bins.addObject(object);
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid storage location.");
          break;
      }
      
      int confirm = JOptionPane.showConfirmDialog(null, "Are you done storing objects in the garage?");
      if (confirm == JOptionPane.YES_OPTION) {
        done = true;
      }
    }
    
    String message = "Garage storage capacity reached.\nCabinets: " + cabinets.getCount() + "\nWork bench: " + workBench.getCount() + "\nBins: " + bins.getCount() + "\n\n";
    message += "Objects stored in Cabinets:\n";
    for (String object : cabinets.getObjects()) {
      message += object + "\n";
    }
    message += "Objects stored in Work Bench:\n";
    for (String object : workBench.getObjects()) {
      message += object + "\n";
    }
    message += "Objects stored in Bins:\n";
    for (String object : bins.getObjects()) {
      message += object + "\n";
    }
    JOptionPane.showMessageDialog(null, message);
  }
}
