package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.subsystems.DriveSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;

/**
 * The command that drives the robot. It can run the robot in percent output or in velocity modes.
 * @author 4533 Programming Team
 *
 */
public class DriveCommand extends Command {

	private Joystick controller;
	private DriveSystem driveSystem = DriveSystem.getInstance();
	private SwingArmSystem swingArmSystem = SwingArmSystem.getInstance();
	
	public DriveCommand() {
		controller = new Joystick(RobotMap.JOYSTICK_PORT);
		requires(DriveSystem.getInstance());
	}
	/**
	 * Runs every 20? MS. Runs DriveSystem.DriveVelocity() or DriveSystem.DriveAction() based of the value of RobotMap.PID_DRIVE_MODE.
	 * DriveVelocity is called when PID_DRIVE_MODE is true. Sets up a dead zone for the controller. Calls DriveSystem.setVelocity(500) when the Joystick buttons are pressed and DriveVelocity(250) when not pressed.
	 */
	protected void execute() {
		double leftStick = controller.getY();
		double rightStick = controller.getRawAxis(3);
		if(controller.getRawButton(RobotMap.RIGHT_BUMPER)|| controller.getRawButton(RobotMap.RIGHT_TRIGGER)) {
			driveSystem.setVelocity(500);
		}
		else {
			driveSystem.setVelocity(250);
		}
		if (Math.abs(rightStick) <= .05) {
			rightStick = 0;
		}
		if (Math.abs(leftStick) <= .05) {
			leftStick = 0;
		}
		if (RobotMap.PID_DRIVE_MODE) {
			driveSystem.driveVelocity(leftStick, rightStick);
		} else {
			driveSystem.driveAction(leftStick, rightStick);
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void initialize() {

	}

	protected void interrupted() {

	}
}
