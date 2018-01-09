package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	private static DriveSystem INSTANCE;
	//Haven't imported in the CANTalon libraries yet, so I am holding off on programming motors
	Joystick stick;
	
	public DriveSystem() {
		stick = new Joystick(0);
	}
	public static void initialize() {
		if(INSTANCE == null) {
			INSTANCE = new DriveSystem();
		}
	}
	public static DriveSystem getInstance() {
		return INSTANCE;
	}
	public void driveAction(double left, double right) {
		//This method used to actually drive the robot
		//this.leftMaster.set(left); and setting all the other motors as well
	}
	public void drivingControls(Joystick j) {
		//Defaulting to tank drive as I know how to code tank drive.
		double leftWheels = j.getRawAxis(3);
		double rightWheels = j.getY();
		this.driveAction(leftWheels, rightWheels);
	}
	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
	}
	//Just some methods we can use in autonomous
	
	public void forward(double v) {
		this.driveAction(v, v);
	}
	public void backward(double v) {
		this.driveAction(v, v);
	}
	public void stop() {
		this.driveAction(0.0, 0.0);
	}
	public void turn(double v, double w) {
		this.driveAction(v, w);
	}
}
