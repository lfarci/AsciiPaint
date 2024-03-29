package g47923.asciipaint.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a drawing.
 *
 * @author g47923
 */
class Drawing {

    private final List<Shape> shapes;
    private final int height;
    private final int width;

    /**
     * Initializes this drawing with the given width and height. It is initially
     * empty.
     *
     * @param height is the height of this drawing.
     * @param width is the width of this drawing.
     */
    public Drawing(int width, int height) {
        if (height < 0) {
            throw new IllegalArgumentException(height + " is not valid, "
                    + "the height should be positive.");
        }
        if (width < 0) {
            throw new IllegalArgumentException(width + " is not valid, "
                    + "the height should be positive.");
        }
        this.shapes = new ArrayList<>();
        this.height = height;
        this.width = width;
    }

    /**
     * Gets the shape of this drawing.
     *
     * @return the shape of this drawing.
     */
    List<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }

    /**
     * Gets the height of this drawing.
     *
     * @return the height of this drawing.
     */
    int getHeight() {
        return height;
    }

    /**
     * Gets the width of this drawing.
     *
     * @return the width of this drawing.
     */
    int getWidth() {
        return width;
    }

    /**
     * Gets the shape containing the given point.
     *
     * @param p is the point to analyze.
     * @return the shape containing the given point, if no shape is found null
     * is returned.
     */
    Shape getShapeAt(Point p) {
        Shape save = null;
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                save = shape;
            }
        }
        return save;
    }

    /**
     * Adds the given shape to this drawing.
     *
     * @param shape is the shape to add.
     */
    void add(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Moves the given shape.
     *
     * @param shape is the shape to move.
     * @param dx is the difference added to the x position.
     * @param dy is the difference added to the y position.
     */
    void move(Shape shape, int dx, int dy) {
        if (!shapes.contains(shape)) {
            throw new IllegalArgumentException("The given shape has not been "
                    + "added yet.");
        }
        shape.move(dx, dy);
    }

    /**
     * Removes the given shape from this drawing.
     *
     * @param shape is the shape to remove.
     */
    void remove(Shape shape) {
        shapes.remove(shape);
    }

    /**
     * Adds the given shapes to this drawing.
     *
     * @param shapes are the shapes to add.
     */
    void addAllShapes(Shape... shapes) {
        this.shapes.addAll(Arrays.asList(shapes));
    }

}
