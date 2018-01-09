package org.usfirst.frc.team4533.robot;

public class OI {
	private static OI INSTANCE;
	OI() {
		
	}
	public static OI getInstance() {
		return INSTANCE;
	}
	public static void initialize() {
		if(INSTANCE == null) {
			INSTANCE = new OI();
		}
	}
}