
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED=20;
	private DigitalVideoDisc itemsOrdered[]=
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public Cart() {
		super();
	}
	public float totalCost() {
		float total=0f;
		for(int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				total=total+ itemsOrdered[i].getCost();
			}
		    }
		return total;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < MAX_NUMBERS_ORDERED; i++)
		    if(itemsOrdered[i] == null) {
		    	itemsOrdered[i] = disc;
		        break;
		    }
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < MAX_NUMBERS_ORDERED; i++)
		    if(itemsOrdered[i] == disc) {
		    	itemsOrdered[i] = null;
		    }
	}
}
