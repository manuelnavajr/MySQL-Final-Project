import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;


import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class TestDemoTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemo#argumentsForAddPositive")
	private void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectedException){
		if (!expectedException){
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else{
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

		}
	}
	
	

	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(arguments(2, 4, 6, false),
				arguments(3, 2, 1, false),
				arguments(2, 2, 4, false),
				arguments(1, 0, 1, true),
				arguments(0, 1, -1, true)
				);
				
	}
	@Test
	void assertThatNumberSquaredisCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);

	}
	

}
