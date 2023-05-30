
public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int count;

    public Store() {
        itemsInStore = new DigitalVideoDisc[0];
        count = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        DigitalVideoDisc[] newItems = new DigitalVideoDisc[count + 1];
        System.arraycopy(itemsInStore, 0, newItems, 0, count);
        newItems[count] = dvd;
        itemsInStore = newItems;
        count++;
        System.out.println("DVD added to the store: " + dvd.getTitle());
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                for (int j = i; j < count - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[count - 1] = null;
                count--;
                System.out.println("DVD removed from the store: " + dvd.getTitle());
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in the store.");
        }
    }
}
