package frc.team4533.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4533.robot.commands.Autonomous;
import frc.team4533.robot.subsystems.DriveSystem;
import frc.team4533.robot.subsystems.IntakeSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class Robot extends IterativeRobot {

	public static Autonomous autonomousCommand;
	public static String gameData; 
	public static SendableChooser<String> positionChooser;
	
	/**
	 * Method is called when the robot is first turned on
	 * Initializes all of the subsystems and OI.
	*/
	public void robotInit() {
		DriveSystem.initialize();
		IntakeSystem.initialize();
		SwingArmSystem.initialize();
		OI.initialize();
		positionChooser = new SendableChooser<String>();
		positionChooser.addDefault("Left Position", "L");
		positionChooser.addObject("Middle Position", "M");
		positionChooser.addObject("Right Position", "R");
		SmartDashboard.putData(positionChooser);
		DriveSystem.getInstance().resetAngle();
		
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
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		DriveSystem.getInstance().resetAngle();
		autonomousCommand = new Autonomous(gameData, positionChooser.getSelected());
		DriveSystem.getInstance().setPIDFValues(0.1, 0.0001, 0, 0);
		DriveSystem.getInstance().setPosition(0);
		autonomousCommand.start();
	}

	/**
	 * Called constantly during the Autonomous Period
	 */
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Robot Angle", DriveSystem.getInstance().getAngle());
		SmartDashboard.putNumber("Left Position", DriveSystem.getInstance().getLeftPosition());
		SmartDashboard.putNumber("Right Position", DriveSystem.getInstance().getRightPosition());
		System.out.println(DriveSystem.getInstance().getAngle());
	}

	/**
	 * What is called at the beginning of the Teleop Period
	 * 
	 *  F-Gain = ( 100% * 1023 ) / MagneticEncoderVelocity
		MagneticEncoderVelocity determinted from TalonSRX self-test
	 	f = 1023 / 3168 = 0.323
	 */
	public void teleopInit() {
		if(autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		// F-Gain = ( 100% * 1023 ) / MagneticEncoderVelocity
		//   MagneticEncoderVelocity determinted from TalonSRX self-test
		// f = 1023 / 3168 = 0.323
		if(RobotMap.PID_DRIVE_MODE) {
			//Was at P=.25 before i changed it
			DriveSystem.getInstance().setPIDFValues(.15, 0, 2.5, 0.243);
		}
		
		
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
		SmartDashboard.putNumber("Robot Angle", DriveSystem.getInstance().getAngle());
	}
	
	
	/**
	 * 
	 * Called constantly when in Test mode
	 */
	public void testPeriodic() {

	}
}
