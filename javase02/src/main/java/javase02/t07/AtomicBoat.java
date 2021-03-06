package javase02.t07;

@ClassPreamble(author = "Alexander Babai", date = "20.10.2002", currentRevision = 2, lastModified = "22.10.2002", lastModifiedBy = "Alexander Babai")
public class AtomicBoat {

	private Engine engine;

	public AtomicBoat() {
		super();
		engine = new Engine();
	}

	public boolean isStarted() {
		return engine.isStarted();
	}

	public void startAtomicBoat() {
		if (engine.isStarted()) {
			System.out.println("The atomic boat already has been started");
		} else {
			engine.startEngine();
			System.out.println("The atomic boat is started");
		}
	}

	public void stopAtomicBoat() {
		if (engine.isStarted()) {
			engine.stopEngine();
			System.out.println("The atomic boat is stopped");
		} else {
			System.out.println("The atomic boat has't been started");
		}
	}

	@ClassPreamble(author = "Alexander Babai", date = "21.10.2002", currentRevision = 2, lastModified = "22.10.2002", lastModifiedBy = "Alexander Babai")
	private class Engine {
		private boolean isStarted;

		public Engine() {
			super();
		}

		public boolean isStarted() {
			return isStarted;
		}

		public void startEngine() {
			if (isStarted) {
				System.out.println("The engine already has been started");
			} else {
				isStarted = true;
				System.out.println("The engine is started");
			}
		}

		public void stopEngine() {
			if (isStarted) {
				isStarted = false;
				System.out.println("The engine is stopped");
			} else {
				System.out.println("The engine has't been started");
			}
		}
	}

}
