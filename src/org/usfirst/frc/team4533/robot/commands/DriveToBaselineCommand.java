package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToBaselineCommand extends Command {
	
	private DriveSystem driveSystem = DriveSystem.getInstance();
	private Joystick controller;
	
	public DriveToBaselineCommand() {
		controller = new Joystick(RobotMap.JOYSTICK_PORT);
		requires(DriveSystem.getInstance());
	}
	
	protected void execute() {
		driveSystem.toBaseline();
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
