// design a data structure such that insert , delete and getrandom
// are O(1)

package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class DataStructure {
    ArrayList<Integer> arrayList;
    HashMap<Integer, Integer> hashMap;

    public DataStructure() {
        arrayList = new ArrayList<>();
        hashMap = new HashMap<>();
    }

    public void add(int x) {
        // if element alreayd exists dont do anything
        if (hashMap.containsKey(x)) {
            return;
        }

        // add the item to end of arraylist
        int size = arrayList.size();
        arrayList.add(x);

        // insert the element, index into hashmap
        hashMap.put(x, size);
    }

    public void remove(int x) {
        //if the element doesnt exist then dont do anything
        if (!hashMap.containsKey(x))
            return;

        //remove it from hashmap
        int index = hashMap.get(x);

        //swap it with last element of arraylist
        int size = arrayList.size();
        int last = arrayList.get(size-1);

        Collections.swap(arrayList, index, size-1);

        hashMap.remove(x);

        hashMap.put(last, index);
    }

    public int getRandom() {
        Random random = new Random();
        int element = random.nextInt(arrayList.size());

        return arrayList.get(element);
    }

    public int search(int x) {
        return hashMap.get(x);
    }
}
