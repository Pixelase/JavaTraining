package javase02.t07;

@ClassPreamble(author = "Alexander Babai", date = "19.10.2002", currentRevision = 3, lastModified = "22.10.2002", lastModifiedBy = "Alexander Babai")
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
