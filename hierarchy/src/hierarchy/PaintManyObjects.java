package hierarchy;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Point;
import java.util.Vector;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
  * A Pane for NetPaint that has all paint objects drawn on it.
  * Currently, a list of paint objects is hardcoded. A Canvas exists
  * in this BorderPane that will draw all PaintObjects stored
  * in this hardCoded Vector<PaintObject> object.
  * 
  * @author Rick Mercer
 */

public class PaintManyObjects extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Vector<PaintObject> allPaintObjects = createVectorOfPaintObjects();
    BorderPane all = new BorderPane();
    Canvas canvas = new Canvas(800, 550);
    all.setCenter(canvas);
    drawAllPaintObects(allPaintObjects, canvas);

    Scene scene = new Scene(all, 800, 550);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void drawAllPaintObects(Vector<PaintObject> allPaintObjects, Canvas canvas) {
    GraphicsContext gc = canvas.getGraphicsContext2D();
    for (PaintObject po : allPaintObjects)
      po.draw(gc);
  }

  private Vector<PaintObject> createVectorOfPaintObjects() {
    // All of these PaintObject objects must be constructed with two Point objects.
    // The first point could be to the upper left or to the lower right 
    Vector<PaintObject> allPaintObjects = new Vector<>();
    // Create six line object, where any line must be drawn between the
    // two Point objects in the provided color. 
    PaintObject a = new Line(Color.RED, new Point(10, 100), new Point(500, 100));
    PaintObject b = new Line(Color.CYAN, new Point(250, 150), new Point(250, 5));
    PaintObject c = new Line(Color.GREEN, new Point(255, 10), new Point(255, 145));
    PaintObject d = new Line(Color.BLACK, new Point(245, 145), new Point(245, 10));
    PaintObject oneMore = new Line(Color.BLACK, new Point(0, 0), new Point(245, 145));
    PaintObject anOther = new Line(Color.GRAY, new Point(500, 0), new Point(255, 145));
    allPaintObjects.add(a);
    allPaintObjects.add(b);
    allPaintObjects.add(c);
    allPaintObjects.add(d);
    allPaintObjects.add(oneMore);
    allPaintObjects.add(anOther);

    // Draw five rectangles
    // First Point(200, 200) is above and the left of the second point
    PaintObject e = new Rectangle(Color.PINK, new Point(200, 200), new Point(350, 500));
    // First Point (150, 300) is below and to the right of the second point
    PaintObject f = new Rectangle(Color.CYAN, new Point(150, 300), new Point(100, 100));
    PaintObject g = new Rectangle(Color.GREEN, new Point(400, 200), new Point(420, 250));
    PaintObject h = new Rectangle(Color.BLUE, new Point(500, 380), new Point(360, 420));
    PaintObject i = new Rectangle(Color.RED, new Point(400, 520), new Point(540, 480));
    allPaintObjects.add(e);
    allPaintObjects.add(f);
    allPaintObjects.add(g);
    allPaintObjects.add(h);
    allPaintObjects.add(i);

    // Draw five ovals 
    // First Point(500, 20) is above and the left of the second point
    PaintObject j = new Oval(Color.BLACK, new Point(500, 20), new Point(600, 220));
    // Make an oval that is wider than higher. First Point is still upper left
    PaintObject k = new Oval(Color.GREEN, new Point(500, 220), new Point(680, 230));
    // First Point(800, 250) is below and to the right of the second point for a circle
    PaintObject l = new Oval(Color.RED, new Point(760, 320), new Point(660, 220));
    // Another circle with upper left to the other side
    PaintObject m = new Oval(Color.BLUE, new Point(600, 350), new Point(700, 400));
    allPaintObjects.add(j);
    allPaintObjects.add(k);
    allPaintObjects.add(l);
    allPaintObjects.add(m);

    PaintObject n = new Picture(new Point(2, 2), new Point(50, 50), "doge.jpeg");
    // The constructor needs to adjust values if from is lower right of to
    PaintObject o = new Picture(new Point(220, 280), new Point(140, 140), "doge.jpeg");
    PaintObject p = new Picture(new Point(500, 320), new Point(700, 460), "doge.jpeg");
    allPaintObjects.add(n);
    allPaintObjects.add(o);
    allPaintObjects.add(p);

    return allPaintObjects;
  }
  static class PaintObject {

	public void draw(GraphicsContext gc) {
		
		
	}
	public static java.awt.Color Fx2Awt(Color c) {
	    int r = (int) (255 * c.getRed());
	    int g = (int) (255 * c.getGreen());
	    int b = (int) (255 * c.getBlue());
	    java.awt.Color awtColor = new java.awt.Color(r, g, b);
	    return awtColor;
	  } 
	public static javafx.scene.paint.Color Awt2Fx(Color awtColor) {
	    int r = awtColor.getRed();
	    int g = awtColor.getGreen();
	    int b = awtColor.getBlue();
	    javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(r, g, b);
	    return fxColor;
	  }
	  
  }
  
  
  class Line extends PaintObject {
	private java.awt.Color c;
	Point p1;
	Point p2;
	public Line(java.awt.Color red, Point point, Point point2) {
		this.c = red;
		this.p1 = point;
		this.p2 = point2;
	}
	
	@Override
	public void draw(GraphicsContext gc){
		gc.setFill(Awt2Fx(c));
		gc.setStroke(Awt2Fx(c));
		
		gc.strokeLine(p1.getX(),p1.getY(),p2.getX(),p2.getY());
	}
	  
  }
  class Picture extends PaintObject {

	public Picture(Point point, Point point2, String string) {
		// TODO Auto-generated constructor stub
	}
	  
  }
  class Oval extends PaintObject {
	private Color c;
	private Point p1;
	private Point p2;
	public Oval(Color blue, Point point, Point point2) {
		this.c = blue;
		this.p1 = point;
		this.p2 = point2;
	}
	@Override
	public void draw(GraphicsContext gc){
		gc.setFill(Awt2Fx(c));
		gc.setStroke(Awt2Fx(c));
		gc.strokeOval(p1.getX(),p1.getY(),p2.getX(),p2.getY());
		gc.fillOval(p1.getX(),p1.getY(),p2.getX(),p2.getY());
	}
	  
  }
  class Rectangle extends PaintObject {

	public Rectangle(Color red, Point point, Point point2) {
		// TODO Auto-generated constructor stub
	}
	  
  }
  
  
}
