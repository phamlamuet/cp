// Java program to demonstrate
// lowerEntry() method
// for <Integer, String>

import java.util.*;

public class Test {
    public static void main(String[] argv)
            throws Exception
    {

        try {

            // creating object of TreeMap<Integer, String>
            TreeMap<Integer, String>
                    treemap = new TreeMap<Integer, String>();

            // populating tree map
            treemap.put(1, "One");
            treemap.put(2, "Two");
            treemap.put(3, "Three");
            treemap.put(4, "Four");
            treemap.put(5, "Five");

            // printing the TreeMap
            System.out.println("TreeMap: " + treemap);

            // getting lowerEntry value for 3
            // using lowerEntry() method
            Map.Entry<Integer, String>
                    value
                    = treemap.higherEntry(3);

            // printing the value
            System.out.println("The lowerEntry value "
                    + " for 3: " + value);
        }

        catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}
