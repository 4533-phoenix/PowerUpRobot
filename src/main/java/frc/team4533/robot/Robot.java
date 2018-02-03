package frc.team4533.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4533.robot.commands.DriveDistance;
import frc.team4533.robot.subsystems.DriveSystem;
import frc.team4533.robot.subsystems.IntakeSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class Robot extends IterativeRobot {

	public static DriveDistance autonomousCommand;
	
	/**
	 * Method is called when the robot is first turned on
	 * Initializes all of the subsystems and OI.
	*/
	public void robotInit() {
		DriveSystem.initialize();
		IntakeSystem.initialize();
		SwingArmSystem.initialize();
		OI.initialize();
		autonomousCommand = new DriveDistance(100);
	}
	/**
	 * What is called when the robot first recognizes it is disabled
	 * 
	 */
	
	public void disabledInit() {

	}

	/**
	 * Called constantly while the robot is disabled
	 */
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	/**
	 * What is called when autonomous first starts
	 * 
	 */
	
	public void autonomousInit() {
		DriveSystem.getInstance().setPIDFValues(0.1, 0, 0, 0);
		DriveSystem.getInstance().setPosition(0);
		autonomousCommand.start();
	}

	/**
	 * Called constantly during the Autonomous Period
	 */
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * What is called at the beginning of the Teleop Period
	 * 
	 * 
	 */
	public void teleopInit() {
		if(autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		DriveSystem.getInstance().setPIDFValues(0.5, 0, 0, 0);
	}
	/**
	 * 
	 * Called constantly during Teleop
	 */
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Velocity", DriveSystem.getInstance().getLeftVelocity());
		SmartDashboard.putNumber("Right Velocity", DriveSystem.getInstance().getRightVelocity());
		SmartDashboard.putNumber("Target L", DriveSystem.getInstance().getLTargetVelocity());
		SmartDashboard.putNumber("Target R", DriveSystem.getInstance().getRTargetVelocity());
		SmartDashboard.putNumber("Potentiometer", SwingArmSystem.getInstance().position());
		SmartDashboard.putNumber("Potentiometer Angle", SwingArmSystem.getInstance().angle());
		SmartDashboard.putData("Pid Stuff", SwingArmSystem.getInstance().getPIDController());
	}
	
	
	/**
	 * 
	 * Called constantly when in Test mode
	 */
	public void testPeriodic() {

	}
}
