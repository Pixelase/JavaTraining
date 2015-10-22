package javase02.t06;

public class Main {

	public static void main(String[] args) {
		AtomicBoat atomicBoat = new AtomicBoat();

		atomicBoat.startAtomicBoat();
		System.out.println();

		atomicBoat.startAtomicBoat();
		System.out.println();

		atomicBoat.stopAtomicBoat();
		System.out.println();

		atomicBoat.stopAtomicBoat();
		System.out.println();
	}

}
