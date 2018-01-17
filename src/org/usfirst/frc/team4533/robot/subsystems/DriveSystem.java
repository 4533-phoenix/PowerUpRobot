package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	private static DriveSystem INSTANCE;
	WPI_TalonSRX leftMaster;
	WPI_TalonSRX leftSlave;
	WPI_TalonSRX rightMaster;
	WPI_TalonSRX rightSlave;
	
	public DriveSystem() {
		rightMaster = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_MASTER);
		leftMaster = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_MASTER);
		rightSlave = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_SLAVE);
		leftSlave = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_SLAVE);
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
		this.leftMaster.set(-left);
		this.rightMaster.set(right);
		System.out.println(left + " " + right);
		this.leftSlave.set(ControlMode.Follower, RobotMap.MOTOR_LEFT_MASTER);
		this.rightSlave.set(ControlMode.Follower, RobotMap.MOTOR_RIGHT_MASTER);
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
	public void toBaseline() {
		//There are 217.40 positions per inch of distance for a 6in wheel
		while(leftSlave.getSelectedSensorPosition(0) < 217.40*120) {
			System.out.println(leftSlave.getSelectedSensorPosition(0));
			this.leftMaster.set(-1);
			this.rightMaster.set(1);
			this.leftSlave.set(ControlMode.Follower, RobotMap.MOTOR_LEFT_MASTER);
			this.rightSlave.set(ControlMode.Follower, RobotMap.MOTOR_LEFT_MASTER);
		}
	}
}
