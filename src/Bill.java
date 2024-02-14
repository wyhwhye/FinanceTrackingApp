import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Description: implement add bill and check bills(category and time line)
 */

public class Bill {
    String path = "bill.txt";
    FileUtil fileUtil = new FileUtil();
    Scanner in = new Scanner(System.in);
    Bill(){
        System.out.println("***Bills***");
        fileUtil.createFile(path);
    }

    public void AddItems(){
        System.out.println("***AddItems***");

        System.out.println("Please enter your bill:");
        System.out.println("(Name) (Price) (Date)");
        System.out.println("\nEXAMPLE");
        System.out.println("'goggle 14$ YYYY-MM-DD'");
        String input1 = in.nextLine();

        System.out.println("\n(Type)");
        System.out.println("clothes");
        String input2 = in.nextLine();

        System.out.println("\n(Notes)");
        System.out.println("black, the magic 5");
        String input3 = in.nextLine();

        fileUtil.writeFile(path, input1,false);
        fileUtil.writeFile(path, input2,false);
        fileUtil.writeFile(path, input3,false);
    }

    public void Categories(){
        System.out.println("***Categories***");
        String[] array = fileUtil.readFile(path);
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (int i = 1; i < array.length; i+=3) {
            if (frequencyMap.containsKey(array[i])) {
                frequencyMap.put(array[i], frequencyMap.get(array[i]) + 1);
            } else {
                frequencyMap.put(array[i], 1);
            }
        }

        // print times
        for (String key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            System.out.println(key + ": " + frequency);
        }

    }

    public void TimeLine() throws ParseException{
        System.out.println("***TimeLine***");
        // enter item name
        ArrayList<Item> items = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] array = fileUtil.readFile(path);
        for (int i = 0; i < array.length; i += 3) {
            String name = separate (array[i], 0);
            String time = separate(array[i], 2);
            items.add(new Item(name, sdf.parse(time)));
        }

        // sorted date
        Collections.sort(items, new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                return item2.getDate().compareTo(item1.getDate());
            }
        });

        // output sorted list
        for (Item item : items) {
            System.out.println(item.getName() + " - " + sdf.format(item.getDate()));
        }
    }

    // define item class
    class Item {
        String name;
        Date date;

        public Item(String name, Date date) {
            this.name = name;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return date;
        }
    }

    public static String separate (String line, int index) {
        int nowIndex = 0;
        Scanner lineScanner = new Scanner(line);
        while (lineScanner.hasNext()) {
            String word = lineScanner.next();
            if (index == nowIndex) {
                return word;
            }
            nowIndex += 1;
        }
        lineScanner.close();
        return "No item";
    }

    public static void main(String[] args) throws ParseException{
        Bill bill = new Bill();
        bill.TimeLine();
    }
}
