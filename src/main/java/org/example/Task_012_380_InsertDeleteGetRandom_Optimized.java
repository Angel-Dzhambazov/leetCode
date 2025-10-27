import java.util.*;

class RandomizedSet {
    private final List<Integer> itemsList;
    private final Map<Integer, Integer> itemsMap;
    private final Random random;

    public RandomizedSet() {
        this.itemsList = new ArrayList<>();
        this.itemsMap = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (itemsMap.containsKey(val)) return false;
        itemsList.add(val);
        itemsMap.put(val, itemsList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!itemsMap.containsKey(val)) return false;

        int indexToRemove = itemsMap.get(val);
        int lastElement = itemsList.get(itemsList.size() - 1);

        // Swap last element with the one being removed
        itemsList.set(indexToRemove, lastElement);
        itemsMap.put(lastElement, indexToRemove);

        // Remove the last element (which is now a duplicate)
        itemsList.remove(itemsList.size() - 1);
        itemsMap.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(itemsList.size());
        return itemsList.get(randomIndex);
    }
}
