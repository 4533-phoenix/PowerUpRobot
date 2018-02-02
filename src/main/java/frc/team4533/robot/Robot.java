package frc.team4533.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
		DriveSystem.getInstance().setPIDFValues(0.5, 0, 0, 0);
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Velocity", DriveSystem.getInstance().getLeftVelocity());
		SmartDashboard.putNumber("Right Velocity", DriveSystem.getInstance().getRightVelocity());
		SmartDashboard.putNumber("Target L", DriveSystem.getInstance().getLTargetVelocity());
		SmartDashboard.putNumber("Target R", DriveSystem.getInstance().getRTargetVelocity());
	}

	public void testPeriodic() {

	}
}
