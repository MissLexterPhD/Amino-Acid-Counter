import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int kProteins = 9;

        for (int i = 0; i < kProteins; i++) {
            String protein = in.readLine();
            String n = in.readLine();
//            System.out.println(n);
            String[] m = n.split(", ");
            for (String food : m) {
                if (!map.containsKey(food)) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(protein);
                    map.put(food, list);
                } else {
                    map.get(food).add(protein);
                }
            }
            in.readLine();
        }

        ArrayList<Food> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(new Food(key, map.get(key)));
        }

        Collections.sort(list);

        for (Food f : list) {
            System.out.println(f.name + ": ");
            System.out.println("\t" + f.proteins.toString() + "\n");
        }
    }
}

class Food implements Comparable<Food> {
    String name;
    ArrayList<String> proteins;

    public Food(String name, ArrayList<String> proteins) {
        this.name = name;
        this.proteins = proteins;
    }

    public int compareTo(Food other) {
        Integer length1 = other.proteins.size();
        Integer length2 = proteins.size();

        return -length2.compareTo(length1);
    }
}
