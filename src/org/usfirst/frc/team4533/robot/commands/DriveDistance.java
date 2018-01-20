package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

	private double distance;
	private DriveSystem driveSystem;
	private double speed;

	public DriveDistance(double distance, double speed) {
		this.distance = distance;
		this.speed = speed;
		driveSystem = DriveSystem.getInstance();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		driveSystem.resetPosition();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		driveSystem.forward(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return driveSystem.getLeftPosition() >= 217.40*distance && driveSystem.getRightPosition() <= -217.40*distance;
	}

	// Called once after isFinished returns true
	protected void end() {
		System.out.println(driveSystem.getLeftPosition()/217.40);
		System.out.println(driveSystem.getRightPosition()/21.40);
		driveSystem.resetPosition();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
