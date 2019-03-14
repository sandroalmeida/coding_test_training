package info.sandroalmeida;

public class TestLRU {

    public static void main(String[] args) {

        LRU cache = new LRU(5);
        cache.put("One", "1-Value");
        cache.put("Two", "2-Value");
        cache.put("Three", "3-Value");
        cache.put("Four", "4-Value");
        cache.put("Five", "5-Value");

        cache.printList();

        cache.put("Six", "6-Value");
        cache.put("Seven", "7-Value");

        cache.printList();

        cache.put("Eight", "8-Value");
        cache.put("Nine", "9-Value");
        cache.put("Ten", "10-Value");

        cache.printList();

        System.out.println(cache.get("One"));
        System.out.println(cache.get("Two"));
        System.out.println(cache.get("Three"));
        System.out.println(cache.get("Six"));

        cache.printList();

        cache.put("Eleven", "11-Value");

        cache.printList();

        System.out.println(cache.get("Six"));

        cache.printList();


    }
}
