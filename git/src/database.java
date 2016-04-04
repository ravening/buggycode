import java.util.*;

class item {
	private String itemName;
	private String location;
	private int count;
	
	public String getName() {
		return this.itemName;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public item(String name, String place, int count) {
		this.itemName = name;
		this.location = place;
		this.count = count;
	}
}

public class database {
	public HashMap<String, item> storage = new HashMap<String, item>();
	public void addItem(String name, String location, int count) {
		//if the item already exists in the database dont add it
		if (storage.containsKey(name)) {
			System.out.println("Item already exists");
			return;
		} else {
			item newItem = new item(name, location, count);
			storage.put(name, newItem);
		}
	}
	
	public void deleteItem(String name) {
		//delete it only if it exists
		if (storage.containsKey(name)) {
			storage.remove(name);
		}
	}
	
	public void searchItem(String name) {
		//base case if name is null
		if (name == null) {
			return;
		}
		
		if (storage.containsKey(name)) {
			item tmp = storage.get(name);
			System.out.println(tmp.getName() + " " + tmp.getLocation() + " " + tmp.getCount());
		} else {
			Set<String> tmpKey = storage.keySet();
			for(String in : tmpKey) {
				if (in.contains(name)) {
					item tmp = storage.get(in);
					System.out.println(tmp.getName() + " " + tmp.getLocation() + " " + tmp.getCount());
				}
			}
			//System.out.println("Item " + name + " doesnt exist");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		database dict = new database();
		dict.addItem("Watch", "table", 3);
		dict.addItem("soap", "sterling container", 2);
		dict.addItem("shirts", "closet", 20);
		dict.addItem("headphone", "table shelf", 1);
		dict.addItem("earphones", "table shelf", 1);
		
		dict.searchItem("headphone");
		dict.searchItem("hone");
	}

}
