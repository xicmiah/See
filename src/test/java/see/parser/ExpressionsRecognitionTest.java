package see.parser;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class ExpressionsRecognitionTest {

    @DataPoints
    public static final String[] logical = {"100500 || c != 9 && a==42"};
    
    @DataPoints
    public static final String[] equality = {"c==9", "a != 42"};

    @DataPoints
    public static final String[] relational = {"1<2", "2 <=3", "9>= 42", "42 > 100500"};

    @DataPoints
    public static final String[] additive = {"1+2", "1+2+3", "1 +2 + 3"};

    @DataPoints
    public static final String[] multiplicative = {"1*2", "1*2*3", "1*2 + 2* 3 + 4"};

    @DataPoints
    public static final String[] unary = {"!9", "-9", "-a", "+9", "+a"};

    @DataPoints
    public static final String[] power = {"9^42", "100500^-9", "(100500)^(9-42)"};

    @DataPoints
    public static final String[] parens = {"1*(2+3)", "(9 + 42)", "1 + (2 + (3+4)) "};

    @DataPoints
    public static final String[] floats = {"0.9", "9.0e6", "42.", ".9", "42.e9"};

    @DataPoints
    public static final String[] functions = {"sum(9, 42)", "cos(0)", "win()"};


    /**
     * Test that grammar recognizes input as valid simple expression (Condition() entry point)
     * @param example input to test
     * @throws Exception
     */
    @Theory
    public void testRecognition(String example) throws Exception {
        assertThat(example, ConditionMatcher.condition());
    }

}