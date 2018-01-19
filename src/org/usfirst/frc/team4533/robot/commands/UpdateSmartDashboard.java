package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UpdateSmartDashboard extends Command {

	DriveSystem driveSystem = DriveSystem.getInstance();
    public UpdateSmartDashboard() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	SmartDashboard.putString("LeftWheelsEncoderLabel", "Left Encoder Position:");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("leftWheelsPositon", driveSystem.getPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
