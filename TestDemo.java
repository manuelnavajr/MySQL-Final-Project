import java.util.Random;

public class TestDemo {

	int addPositive(int a, int b) {
	
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
	}
	int randomNumberSquared() {
		int i = getRandomInt();
		return i*i;
	}
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	}
