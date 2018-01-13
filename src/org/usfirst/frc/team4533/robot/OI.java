package org.usfirst.frc.team4533.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
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