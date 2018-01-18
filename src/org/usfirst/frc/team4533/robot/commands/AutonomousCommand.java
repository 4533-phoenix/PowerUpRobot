package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
	DriveSystem driveSystem = DriveSystem.getInstance();
	public AutonomousCommand() {
		this.addSequential(new DriveDistance(120), 15000);
	}
}
