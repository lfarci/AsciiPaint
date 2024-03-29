package g47923.asciipaint;

import g47923.asciipaint.controller.Controller;
import g47923.asciipaint.model.AsciiPaint;

/**
 * Entry point of the game.
 *
 * @author g47923
 */
public class Application {

    /**
     * Starts the program.
     *
     * @param args is width and height of the program drawing. If args is empty,
     * the drawing is initialized with default size.
     */
    public static void main(String[] args) {
        if (args.length == 1 || args.length > 2) {
            System.out.println("usage: none or two arguments are required.");
            System.exit(-1);
        }
        if (args.length == 0) {
            startDefault();
            System.exit(-2);
        }
        try {
            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);
            startCustom(width, height);

        } catch (NumberFormatException ex) {
            System.err.println("usage: invalid arguments, it should be the width"
                    + " and height of the drawing.");
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }

    }

    /**
     * Starts this program with default width and height for the drawing. By
     * default, the drawing is 50 x 50.
     */
    public static void startDefault() {
        AsciiPaint asciiPaint = new AsciiPaint();
        Controller c = new Controller(asciiPaint);
        c.start();
    }

    /**
     * Starts this program with custom width and height for the drawing.
     *
     * @param width is the width of the drawing.
     * @param height is the height of the drawing.
     */
    public static void startCustom(int width, int height) {
        AsciiPaint asciiPaint = new AsciiPaint(width, height);
        Controller c = new Controller(asciiPaint);
        c.start();
    }

}
