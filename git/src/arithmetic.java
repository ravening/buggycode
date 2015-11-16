
public class arithmetic  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add a = new Add();
		Mul m = new Mul();
		
		a.start();
		m.start();
		
		try {
			a.join();
			m.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		int value = a.value / m.value;
		
		System.out.println(value);
	}

}

class Add extends Thread {
	 int value;
	
	public void run() {
		value = 1 + 3;
	}
}

class Mul extends Thread {
	 int value;
	
	public void run() {
		value = 1 * 2;
	}
}