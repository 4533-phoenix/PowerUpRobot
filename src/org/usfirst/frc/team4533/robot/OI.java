package org.usfirst.frc.team4533.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4533.robot.commands.*;
public class OI {
	Joystick stick = new Joystick(RobotMap.JOYSTICK_PORT);
	private static OI INSTANCE;
	JoystickButton intakeButton = new JoystickButton(stick, RobotMap.RIGHT_TRIGGER);
	OI() {
		intakeButton.whileHeld(new IntakeCommand(1));
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