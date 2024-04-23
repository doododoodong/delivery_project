package miniproject;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		DeliveryService ds=new DeliveryService();
		
		Tool.print("###     WELCOME!!    ###");
		Tool.print("###  Happy Delivery  ###");
		Tool.print("");

		ds.homeMenu();

	}

}
