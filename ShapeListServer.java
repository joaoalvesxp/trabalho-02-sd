import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class ShapeListServer {
	public static void main(String args[]){
        try{
        	LocateRegistry.createRegistry(1099);
        	System.out.println("LocateRegistry OK");
            ShapeList aShapelist = new ShapeListServant();
            System.out.println("After create");
			Naming.bind("rmi://localhost/ShapeList", aShapelist);
            System.out.println("ShapeList server ready");
        }catch(Exception e) {
            System.out.println("ShapeList server main " + e.getMessage());
        }
    }
}