import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"}) // test will run 3 times as parameter
    void testCase1(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    // mvn -Dtest=TestCircle#mytest test
    // maven-surefire-plugin
    // mvn clean test

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 10})
    void testCase2(int number) {
        Assertions.assertEquals(0, number % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")// will get the data from provided method (stringProvider)
    void testCase4(String arg) {
        Assertions.assertNotNull(arg);
    }

    static String[] stringProvider() {
        return new String[]{"Java", "JS", "TS"};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30", "20,20,40", "30,20,100"}) // each string will be assigned the nums that we have on method parameter
    void testCase5(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2)); // 10+20=30, 20+20=40,
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)// numLinesToSkipwill skip the first line of the csv file which is the header
    void testCase6(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

}
