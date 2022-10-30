import java.util.ArrayList; // import the ArrayList class

/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom; // add another boolean that checks whether there is a dining room in the house

  /* Constructer of the house */
  public House(String name, String address, int nFloors, boolean hasDin) {
    super(name, address, nFloors); // variables in the super class
    this.hasDiningRoom = hasDin;
    this.residents = new ArrayList<String>();
  }
  /* check if the house has dining room */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }
  /* check how many residents are in the house */
  public int nResidents() {
    return this.residents.size();
  }
  /* check how many residents are in the house */
  public void moveIn(String name) {
    residents.add(name);

  }

  /* some one move out from the house and return the name of the person who moved out */
  public String moveOut(String name) {
    if (residents.contains(name)) {
      residents.remove(name);
      System.out.println(name + " moved out from the house.");
    }
    return name;
  } 

  public static void main(String[] args){
    System.out.println("You have built a house: 🏠");
    House myHouse = new House("Cutter", "10 Prospect Street", 3, true);
    System.out.println(myHouse);
    myHouse.moveIn("Lynne");
    myHouse.moveIn("Iris");
    myHouse.moveIn("Rayna");
    myHouse.moveIn("Sofi");
    System.out.println("Residents in this house:" + myHouse.residents);
    myHouse.moveOut("Sofi");
    System.out.println("Residents in this house:" + myHouse.residents);
    System.out.println("There are " + myHouse.residents.size() + " people in the house.");
    System.out.println("Is there a diningroom in the house? " + myHouse.hasDiningRoom);
  }
}