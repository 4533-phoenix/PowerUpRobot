package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	
	private Joystick controller;
	
	public DriveCommand() {
		controller = new Joystick(0);
		requires(Robot.driveSystem);
	}
	
	protected void execute() {
		Robot.driveSystem.drivingControls(this.controller);
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
