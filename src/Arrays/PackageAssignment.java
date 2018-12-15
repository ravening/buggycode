package Arrays;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PackageAssignment extends RuntimeException {

    static class Item {
        int index;
        int weight;
        int value;

        public Item(int index, int weight, int value) {
            this.index = index;
            this.weight = weight;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void pack(int weight, List<Item> itemList) {
        int n = itemList.size();

        int[][] array = new int[n+1][weight+1];

        for (int i = 0 ; i <= n; i++) {
            for (int j = 0; j <= weight; j++) {
                if (i == 0 || j == 0){
                    array[i][j] = 0;
                } else if (itemList.get(i-1).getWeight() <= j) {
                    array[i][j] = Math.max(itemList.get(i-1).getValue() +
                            array[i-1][j - itemList.get(i-1).getWeight()], array[i-1][j]);
                } else {
                    array[i][j] = array[i-1][j];
                }
            }
        }

        System.out.println("answer is " +array[n][weight]);

    }
    public static void main(String[] args) {
        String inputFile;
        Scanner user = new Scanner(System.in);

        System.out.print("Please enter the file name: ");
        inputFile = user.nextLine().trim();

        //System.out.println("File name is " + inputFile);
        Scanner scan = null;
        File input = new File(inputFile);
        try {
            scan = new Scanner(input);
        } catch (FileNotFoundException ex) {
            System.out.print("File not found");
            return;
        }

        String line;
        String regex = "\\((.*?)\\)";
        List<Item> itemList = new ArrayList<>();
        int count = 0;
        while( scan.hasNextLine() )
        {
            count++;
            line = scan.nextLine();
            String[] array = line.replaceAll("\\s+", "").split(":");
            if (array.length != 2) {
                throw new RuntimeException("Invalid line number: " + count);
            }

            if (Integer.parseInt(array[0]) > 100) {
                throw new RuntimeException("Maximum weight allowed is 100");
            }
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(array[1]);

            System.out.println(matcher.groupCount());
            int itemCount = array[1].length() - array[1].replaceAll("\\(", "").length();
            if (itemCount > 15) {
                throw new RuntimeException("Maximum item count is 15 per line");
            }
            while (matcher.find()) {
                String[] numbers = matcher.group()
                        .replaceAll("[(|)]", "")
                        .split(",");

                if (numbers.length != 3) {
                    throw new RuntimeException("Invalid item");
                }

                try {
                    int index = Integer.parseInt(numbers[0]);
                    int weight = Integer.parseInt(numbers[1]);
                    int value = Integer.parseInt(numbers[2]);
                    Item newItem = new Item(index, weight, value);
                    itemList.add(newItem);
                    if (weight > 100.0 || value > 100.0) {
                        throw new RuntimeException("Maximum weight or value of an item is 100");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid item data: " + ex.getMessage());
                    throw new RuntimeException();
                }
            }

            pack(Integer.parseInt(array[0]), itemList);
        }
    }
}
