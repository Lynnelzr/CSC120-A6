import java.util.Hashtable;
import java.util.Set;

/* This is a stub for the Library class */
  public class Library extends Building{
    private Hashtable <String, Boolean> collection;
    public Library(String name, String address, int nFloors) {
     super(name, address, nFloors); // variables in the super class
     this.collection = new Hashtable<>();
     System.out.println("You have built a library: 📖");
    }

    /* add the book to the hashtable collection */
    public void addTitle(String title){
      collection.put(title, true);
    } 

    /* return the title that we removed */
    public String removeTitle(String title){
      collection.remove(title);
      return title;
    } 
    /* replace the value of this key to false when the book is checked out */
    public void checkOut(String title){
      collection.replace(title, false);
    }

    /* replace the value of this key to true after the book is returned */
    public void Return(String title){
      collection.replace(title, true);
    }
    
    /* returns true if the title appears as a key in the Libary's collection, false otherwise */
    public boolean containsTitle(String title){
    if (collection.containsKey(title)) { //check if there is key "title"
      System.out.println("Yes");
      return true;
    } else{
      System.out.println("No");
      return false;
      }
    }
    /* check if the title we are finding is existing in the collecting
     * if not, throw exception
     * returns true if the title is currently available, false otherwise 
     */
    public boolean isAvailable(String title){
    if (collection.containsKey(title)){
      if (collection.get(title).equals(true)){
        System.out.println("This book is available.");
        return true;
      }
      else {
        System.out.println("This book is not available.");
        return false;
        }
      } 
      else {
        throw new RuntimeException("This book is not in our collection.");}
    }
    
    /* prints out the entire collection in an easy-to-read way (including checkout status) */
    public void printCollection(){
      Set<String> keys = this.collection.keySet();
      for (String key: keys){
        if(this.collection.get(key) == true){
          System.out.println(key + " (Available)");
        } else{
          System.out.println(key + " (Not Available)");
        }
      }
    } 
  
    public static void main(String[] args){
      Library myLibrary = new Library("Neilson", "7 Neilson Drive", 4);
      myLibrary.addTitle("Jane Eyre by Charlotte Brontë");
      myLibrary.addTitle("The Great Gatsby by F. Scott Fitzgerald");
      myLibrary.printCollection();
      myLibrary.removeTitle("Jane Eyre by Charlotte Brontë");
      System.out.println("After remove a book.");
      myLibrary.printCollection();
      myLibrary.checkOut("The Great Gatsby by F. Scott Fitzgerald");
      System.out.println("Check out a book.");
      myLibrary.printCollection();
      myLibrary.Return("The Great Gatsby by F. Scott Fitzgerald");
      System.out.println("Return a book.");
      myLibrary.printCollection();
      System.out.println("Does the collection contain The Great Gatsby? ");
      myLibrary.containsTitle("The Great Gatsby by F. Scott Fitzgerald");
      System.out.println("Is the Jane Eyre available in the collection?");
      myLibrary.isAvailable("Jane Eyre by Charlotte Brontë");
    }
  }