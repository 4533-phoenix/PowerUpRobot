package frc.team4533.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team4533.robot.commands.DriveDistance;
import frc.team4533.robot.subsystems.DriveSystem;

public class Robot extends IterativeRobot {

	public static DriveDistance autonomousCommand;
	public void robotInit() {
		DriveSystem.initialize();
		autonomousCommand = new DriveDistance(100);
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		DriveSystem.getInstance().setPIDFValues(0.1, 0, 0, 0);
		DriveSystem.getInstance().setPosition(0);
		autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if(autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		DriveSystem.getInstance().setPIDFValues(0.113333, 0, 0, .1097);
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {

	}
}
