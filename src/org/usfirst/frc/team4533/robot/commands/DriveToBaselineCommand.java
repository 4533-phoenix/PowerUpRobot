package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToBaselineCommand extends Command {
	
	private DriveSystem driveSystem = DriveSystem.getInstance();
	private Joystick controller;
	private double speed;
	public DriveToBaselineCommand(double speed) {
		controller = new Joystick(RobotMap.JOYSTICK_PORT);
		this.speed = speed;
		requires(DriveSystem.getInstance());
	}
	
	protected void execute() {
		driveSystem.toBaseline(speed);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}
	
	protected void initialize() {
		
	}
	
	protected void interrupted() {
		
	}
}
