import java.util.HashMap;
import java.util.Map.Entry;

class Main {
    public static void main(String[] drss) {

        HashMap<String, String> Fruits = new HashMap<>();
        Fruits.put("Apple", "Red");
        Fruits.put("Banana", "Yellow");
        Fruits.put("Mangoo", "Orangecolour");
        System.out.println("HashMap: " + Fruits);
        // get() method to get value
        String value = Fruits.get("Banana");
        System.out.println("Value at index 1: " + value);
        System.out.println(Fruits.keySet() + "++++++++++++++++" + Fruits.values());
        for (Entry<String,String> E : Fruits.entrySet()) {
           System.out.println( E.getKey()+" %%%%%%%%%%%%%%%%%%%%   "+E.getValue());
            
        }
        
        }
    }
