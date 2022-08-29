package pattern.com;

public class Driver {
public static void main(String[] args) {
	ShapeFactory sc = new ShapeFactory();
	
	Shape rectangle = sc.getShapeInstance("Rectangle");
	rectangle.draw();
    
    Shape circle = sc.getShapeInstance("Circle");
    circle.draw();
    
    Shape square = sc.getShapeInstance("Square");
    square.draw();
}
}
