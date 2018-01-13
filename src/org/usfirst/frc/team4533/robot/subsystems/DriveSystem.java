package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	private static DriveSystem INSTANCE;
	TalonSRX leftMaster;
	TalonSRX leftSlave;
	TalonSRX rightMaster;
	TalonSRX rightSlave;
	Joystick stick;
	
	public DriveSystem() {
		rightMaster = new TalonSRX(RobotMap.MOTOR_RIGHT_MASTER);
		leftMaster = new TalonSRX(RobotMap.MOTOR_LEFT_MASTER);
		rightSlave = new TalonSRX(RobotMap.MOTOR_RIGHT_SLAVE);
		leftSlave = new TalonSRX(RobotMap.MOTOR_LEFT_SLAVE);
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
		this.leftMaster.set(ControlMode.Current, left);
		this.rightMaster.set(ControlMode.Current, right);
		this.leftSlave.set(ControlMode.Current, RobotMap.MOTOR_LEFT_MASTER);
		this.rightSlave.set(ControlMode.Current, RobotMap.MOTOR_RIGHT_MASTER);
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
