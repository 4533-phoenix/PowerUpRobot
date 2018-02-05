package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.subsystems.DriveSystem;

public class DriveCommand extends Command {

	private Joystick controller;
	private DriveSystem driveSystem = DriveSystem.getInstance();

	public DriveCommand() {
		controller = new Joystick(RobotMap.JOYSTICK_PORT);
		requires(DriveSystem.getInstance());
	}

	protected void execute() {
		if(RobotMap.PID_DRIVE_MODE) {
			driveSystem.driveVelocity(controller.getY(), controller.getRawAxis(3));
		}
		else {
			driveSystem.driveAction(controller.getY(), controller.getRawAxis(3));
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
