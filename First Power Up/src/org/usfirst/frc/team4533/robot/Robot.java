package org.usfirst.frc.team4533.robot;

import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	public static DriveSystem driveSystem;
	
	public void robotInit() {
		driveSystem = new DriveSystem();
	}
	public void disabledInit() {
		
	}
	public void disabledPeriodic() {
		
	}
	public void autonomousInit() {
		
	}
	public void autonomousPeriodic() {
		
	}
	public void teleopInit() {
		
	}
	public void teleopPeriodic() {
		
	}
	public void testPeriodic() {
		
	}
}