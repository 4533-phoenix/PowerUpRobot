package frc.team4533.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team4533.robot.subsystems.DriveSystem;

public class Robot extends IterativeRobot {

	// public static NameOfAutonomousCommand autonomousCommand;
	public void robotInit() {
		DriveSystem.initialize();
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
		// if(autonomousCommand != null) {
		// autonomousCommand.cancel();
		// }
		DriveSystem.getInstance().setPIDFValues(0.113333, 0, 0, .1097);
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {

	}
}
