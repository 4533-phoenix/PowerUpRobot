package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.subsystems.DriveSystem;

public class DriveDistance extends Command {
	
	private DriveSystem driveSystem = DriveSystem.getInstance();
	private double distance;
	private static final double CIRCUMFERENCE = 6*Math.PI;
	private static final double UNITS_PER_INCH = DriveSystem.UNITS_PER_REVOLUTION/CIRCUMFERENCE;
	
	public DriveDistance(double distance) {
		this.requires(driveSystem);
		this.distance = distance * UNITS_PER_INCH;
	}
	
	public void execute() {
		driveSystem.drivePosition((int)(-distance));
	}
	
	@Override
	protected boolean isFinished() {
		return (driveSystem.getLeftPosition() >= distance) && (driveSystem.getRightPosition() >= distance);
	}

}
