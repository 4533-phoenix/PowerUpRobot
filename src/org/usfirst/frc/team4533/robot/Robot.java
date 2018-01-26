package org.usfirst.frc.team4533.robot;

import org.usfirst.frc.team4533.robot.commands.AutonomousCommand;
import org.usfirst.frc.team4533.robot.commands.UpdateSmartDashboard;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	public static AHRS ahrs;
	public static SmartDashboard smartDashboard;
	public static AutonomousCommand autonomousCommand;
	public static UpdateSmartDashboard updateSmartDashboard;

	public void robotInit() {
		DriveSystem.initialize();
		autonomousCommand = new AutonomousCommand();
		smartDashboard = new SmartDashboard();
		updateSmartDashboard = new UpdateSmartDashboard();
		ahrs = new AHRS(SPI.Port.kMXP);
		ahrs.enableLogging(true);
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		// updateSmartDashboard.update();
	}

	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		// updateSmartDashboard.update();

		if (!ahrs.isCalibrating()) {
			try {
				System.out.println("Angle: " + ahrs.getAngle());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void testPeriodic() {

	}
}