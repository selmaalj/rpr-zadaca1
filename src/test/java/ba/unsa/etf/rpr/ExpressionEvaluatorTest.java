package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest {
    @Test
    void testIzuzetka() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( 5 )");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( 1 + 2 + 3 )");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( )");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate(" ");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate("( ( 2 + 2 ) ");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate(" 1 + ( 2 * 3 )   ");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate(" 1 + ( 2 + 4 + 6 )  ");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate(" ( 1 / ( 4 * 7 )))  ");
        });
        Assertions.assertThrows(RuntimeException.class, () -> {
            ExpressionEvaluator.evaluate(" ( 7 / 0 ) ");
        });
    }
    @Test
    void testEvaluate(){
        Assertions.assertEquals(14.0, ExpressionEvaluator.evaluate(" ( 2 * ( 3 + 4 ) )"));
        Assertions.assertEquals(5.0, ExpressionEvaluator.evaluate(" ( ( sqrt 100 ) / 2 )"));
        Assertions.assertEquals(18.0, ExpressionEvaluator.evaluate("( ( ( sqrt 36 ) / 2 ) * 6 )"));
        Assertions.assertEquals(3.6, ExpressionEvaluator.evaluate(" 3.6 "));
        Assertions.assertEquals(0.0, ExpressionEvaluator.evaluate(" ( 5.7 * 0 ) "));
        Assertions.assertEquals(3.75, ExpressionEvaluator.evaluate("( ( 1 + ( ( ( sqrt ( 9 * ( 2 - 1 ) ) ) / 1.5 ) / 8 ) ) * 3 )"));
        Assertions.assertEquals(3.4641016151377544, ExpressionEvaluator.evaluate(" ( sqrt ( sqrt 144 ) )"));
    }
}
