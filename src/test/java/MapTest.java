import Model.Ball;
import Model.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    private Ball ball;
    private Map map;

    @BeforeEach
    void setUp() {
        ball = new Ball();
        map = new Map(ball);
    }

    @ParameterizedTest
    @CsvSource({"1, 4, 0", "6, 5, 0", "6, 5, 0"})
    void testMoveUp(int posRow, int posColumn, int expected) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Map.class.getDeclaredMethod("moveUp");
        method.setAccessible(true);
        ball.setPosRow(posRow);
        ball.setPosColumn(posColumn);
        method.invoke(map);
        int actualPosRow = ball.getPosRow();
        assertEquals(expected, actualPosRow);
    }

    @ParameterizedTest
    @CsvSource({"0, 1, 1", "4, 4, 0", "6, 5, 4"})
    void testMoveLeft(int posRow, int posColumn, int expected) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Map.class.getDeclaredMethod("moveLeft");
        method.setAccessible(true);
        ball.setPosRow(posRow);
        ball.setPosColumn(posColumn);
        method.invoke(map);
        int actualPosColumn = ball.getPosColumn();
        assertEquals(expected, actualPosColumn);
    }

    @ParameterizedTest
    @CsvSource({"1, 6, 3", "3, 5, 6", "0, 1, 2"})
    void testMoveDown(int posRow, int posColumn, int expected) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Map.class.getDeclaredMethod("moveDown");
        method.setAccessible(true);
        ball.setPosRow(posRow);
        ball.setPosColumn(posColumn);
        method.invoke(map);
        int actualPosRow = ball.getPosRow();
        assertEquals(expected, actualPosRow);
    }

    @ParameterizedTest
    @CsvSource({"0, 1, 3", "4, 4, 6", "5, 3, 6"})
    void testMoveRight(int posRow, int posColumn, int expected) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Map.class.getDeclaredMethod("moveRight");
        method.setAccessible(true);
        ball.setPosRow(posRow);
        ball.setPosColumn(posColumn);
        method.invoke(map);
        int actualPosColumn = ball.getPosColumn();
        assertEquals(expected, actualPosColumn);
    }

    @ParameterizedTest
    @CsvSource({"3, 3, false", "4, 4, false", "5, 2, true"})
    void testVictory(int posRow, int posColumn, boolean expected) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Map.class.getDeclaredMethod("victory");
        method.setAccessible(true);
        ball.setPosRow(posRow);
        ball.setPosColumn(posColumn);
        assertEquals(expected, method.invoke(map));
    }

}