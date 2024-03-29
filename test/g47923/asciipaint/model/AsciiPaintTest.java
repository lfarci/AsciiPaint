package g47923.asciipaint.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the AsciiPaint class.
 *
 * @author Logan
 */
public class AsciiPaintTest {

    @Test
    public void initilizationWithoutArguments() {
        AsciiPaint ap = new AsciiPaint();
        assertTrue(ap.getDrawing().getHeight() == 50
                && ap.getDrawing().getWidth() == 50
                && ap.getDrawing().getShapes().isEmpty());
    }

    @Test
    public void initilizationWithArguments() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        assertTrue(ap.getDrawing().getHeight() == 30
                && ap.getDrawing().getWidth() == 100
                && ap.getDrawing().getShapes().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void initilizationWithNegativeHeight() {
        new AsciiPaint(100, -30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initilizationWithNegativeWidth() {
        new AsciiPaint(-100, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCircleNegativeRadius() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newCircle(0, 0, -4, 'a');
    }

    public void newCircleAddedToDrawing() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newCircle(0, 0, 4, 'a');
        assertTrue(ap.getDrawing().getShapes().get(0) instanceof Circle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newRectangleNegativeHeight() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newRectangle(0, 0, 5, -4, 'a');
    }

    @Test(expected = IllegalArgumentException.class)
    public void newRectangleNegativeWidth() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newRectangle(0, 0, -5, 4, 'a');
    }

    public void newRectangleAddedToDrawing() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newRectangle(0, 0, 3, 5, 'a');
        assertTrue(ap.getDrawing().getShapes().get(0) instanceof Rectangle);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newSquareNegativeSide() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newSquare(0, 0, -1, 'a');
    }

    @Test
    public void newSquareAddedToDrawing() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newSquare(0, 0, 2, 'a');
        assertTrue(ap.getDrawing().getShapes().get(0) instanceof Square);
    }

    @Test
    public void newTriangleAdded() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newTriangle(1, 2, 3, 4, 5, 6, 't');
        assertTrue(ap.getDrawing().getShapes().get(0) instanceof Triangle);
    }

    @Test(expected = IllegalStateException.class)
    public void moveShapeBlankDrawing() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.moveShapeAt(0, 0, 2, 2);
    }

    @Test
    public void moveSquare() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newSquare(0, 0, 2, 's');
        ap.moveShapeAt(0, 0, 2, 2);
        Square addedShape = (Square) ap.getDrawing().getShapes().get(0);
        assertTrue(addedShape.getUpperLeft().getX() == 2
                && addedShape.getUpperLeft().getY() == 2);
    }

    @Test
    public void removeShape() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        ap.newTriangle(1, 2, 3, 4, 5, 6, 't');
        ap.newSquare(0, 0, 2, 'a');
        ap.removeShapeAt(1, 1);
        ap.removeShapeAt(1, 2);
        assertTrue(ap.getDrawing().getShapes().isEmpty());
    }

    @Test
    public void testAsAscii() {
        AsciiPaint ap = new AsciiPaint(100, 30);
        assertFalse(ap.asAscii().isEmpty());
    }

    @Test
    public void testAsAsciiContent() {
        AsciiPaint ap = new AsciiPaint(10, 10);
        ap.newSquare(1, 1, 1, 's');
        String str = ap.asAscii();
        assertEquals(1, str.indexOf("s"));
    }

}
