package org.usfirst.frc.team4533.robot;

import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	
	public static DriveSystem driveSystem;
	public static OI oi;
	//public static NameOfAutonomousCommand autonomousCommand;
	public void robotInit() {
		driveSystem = new DriveSystem();
		oi = new OI();
	}
	public void disabledInit() {
		
	}
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	public void autonomousInit() {
		
	}
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	public void teleopInit() {
//		if(autonomousCommand != null) {
//			autonomousCommand.cancel();
//		}
	}
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	public void testPeriodic() {
		
	}
}