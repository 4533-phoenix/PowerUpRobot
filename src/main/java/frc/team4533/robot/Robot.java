package frc.team4533.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4533.robot.commands.Autonomous;
import frc.team4533.robot.subsystems.DriveSystem;
import frc.team4533.robot.subsystems.IntakeSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;
import frc.team4533.robot.utilities.SmartDashboardValues;

/**
 * The class that the robot runs through. It is the closest thing to a main method the program has.
 * @author 4533 Programming Team
 *
 */
public class Robot extends IterativeRobot {

	public static Autonomous autonomousCommand;
	public static String gameData;
	public SmartDashboardValues smartDashboardValues;
	public SendableChooser<String> autoPositionChooser;
	
	/**
	 * Method is called when the robot is first turned on
	 * Initializes all of the subsystems and OI.
	*/
	public void robotInit() {
		DriveSystem.initialize();
		IntakeSystem.initialize();
		SwingArmSystem.initialize();
		OI.initialize();
		DriveSystem.getInstance().resetAngle();
		smartDashboardValues = new SmartDashboardValues();
		autoPositionChooser = new SendableChooser<String>();
		autoPositionChooser.addDefault("Left Position", "L");
		autoPositionChooser.addObject("Middle Position", "M");
		autoPositionChooser.addObject("Right Position", "R");
		SmartDashboard.putData(autoPositionChooser);
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
		DriveSystem.getInstance().setPeakOutput(.5);
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		DriveSystem.getInstance().resetAngle();
		autonomousCommand = new Autonomous(gameData, autoPositionChooser.getSelected());
		DriveSystem.getInstance().setPIDFValues(0.1, 0.0001, 0, 0);
		DriveSystem.getInstance().setPosition(0);
		
		autonomousCommand.start();
	}

	/**
	 * Called constantly during the Autonomous Period
	 */
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		smartDashboardValues.updateValues();
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
		DriveSystem.getInstance().setPeakOutput(1);
		
		
	}
	/**
	 * 
	 * Called constantly during Teleop
	 */
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		smartDashboardValues.updateValues();
	}
	
	
	/**
	 * 
	 * Called constantly when in Test mode
	 */
	public void testPeriodic() {

	}
}
