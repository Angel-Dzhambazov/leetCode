package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class Task_012_380_InsertDeleteGetRandom {
    public static void main(String[] args) {
        String[] commands = new String[]{"RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"};
        int[] values = {0, 1, 2, 2, 0, 1, 2,};

        RandomizedSet obj = new RandomizedSet();

        for (int i = 1; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "insert" -> obj.getResults().add(obj.insert(values[i]));
                case "remove" -> obj.getResults().add(obj.remove(values[i]));
                case "getRandom" -> obj.getResults().add(obj.getRandom());
                default -> {
                    throw new IllegalArgumentException("Unknown command received: " + command);
                }
            }
        }

        System.out.println(obj.getResults());


    }

    static class RandomizedSet {
        public List<Object> getResults() {
            return results;
        }

        private List<Object> results;
        private List<Integer> itemsList;
        private Map<Integer, Integer> itemsMap;
        private Random random = new Random();

        public RandomizedSet() {
            results = new ArrayList<>();
            itemsList = new ArrayList<>();
            itemsMap = new HashMap<>();
            results.add(null);
        }

        public boolean insert(int val) {
            if (itemsMap.containsKey(val)) {
                return false;
            } else {
                itemsList.add(val);
                itemsMap.put(val, itemsList.size() - 1);
                return true;
            }
        }

        public boolean remove(int val) {
            if (itemsMap.containsKey(val)) {
                int indexToRemove = itemsMap.get(val); // getting the index from the map, where the value is stored in the list
                int lastElement = itemsList.get(itemsList.size() - 1); // getting the element, that is stored at the last place
                itemsList.set(indexToRemove, lastElement); // set the last element on the place of the value that we want to delete
                itemsMap.put(lastElement, indexToRemove); // overwrite the map with the correct index for the last element
                itemsList.remove(itemsList.size() - 1); // delete the last item from the list, now that it is duplicated
                itemsMap.remove(val); // remove the key-value pair for the value that we want deleted
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            int i = random.nextInt(itemsList.size());
            return itemsList.get(i);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
