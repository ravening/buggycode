import java.util.*;

public class demo {
	public HashMap<String, LinkedList<String>> family;
	
	public demo() {
		family = new HashMap<String, LinkedList<String>>();
	}
	
	public void addChild(String parent, String child) {
		if (family.get(parent) != null) {
			family.get(parent).add(child);
		} else {
			family.put(parent, new LinkedList<String>());
			family.get(parent).add(child);
		}
	}
	
	public void displayFamily() {
		Set<String> keys = family.keySet();
		
		for (String parent : keys) {
			System.out.println(parent + "->" + family.get(parent));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo myfamily = new demo();
		myfamily.addChild("venkatesh", "rakesh");
		myfamily.addChild("badriprasad", "pooja");
		myfamily.addChild("badriprasad", "poorna");
		myfamily.addChild("jayasimha", "indira");
		myfamily.addChild("jayasimha", "Namith");
		myfamily.addChild("nagarajarao", "malini");
		myfamily.addChild("nagarajarao", "lalitha");
		
		myfamily.displayFamily();
	}

}
