package pattern.com;

public class ShapeFactory {
	
	public Shape getShapeInstance(String type) {
		
	if(type==null) {
		return null;
		
	}
	if(type.equalsIgnoreCase("SQUARE")) {
		return new Square();
	}
	if(type.equalsIgnoreCase("RECTANGLE")) {
		return new Rectangle();
}
	if(type.equalsIgnoreCase("CIRCLE")) {
		return new Circle();
		
	}
	return null;
	}
}
