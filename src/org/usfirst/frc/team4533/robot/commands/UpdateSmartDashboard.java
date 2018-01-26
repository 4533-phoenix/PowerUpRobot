package org.usfirst.frc.team4533.robot.commands;

import org.usfirst.frc.team4533.robot.Robot;
import org.usfirst.frc.team4533.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UpdateSmartDashboard {
	private boolean alliance = false;
	private boolean ourSwitchL;
	private boolean ourSwitchR;
	private boolean scaleL;
	private boolean scaleR;
	private boolean theirSwitchL;
	private boolean theirSwitchR;
	private DriveSystem driveSystem = DriveSystem.getInstance();

	public UpdateSmartDashboard() {
	}

	public void update() {
		if (DriverStation.getInstance().getAlliance() == Alliance.Red) {
			alliance = true;
		} else {
			alliance = false;
		}
		if (DriverStation.getInstance().getGameSpecificMessage().equals("LLL")) {
			ourSwitchL = alliance;
			ourSwitchR = !alliance;
			scaleL = alliance;
			scaleR = !alliance;
			theirSwitchL = alliance;
			theirSwitchR = !alliance;
		} else if (DriverStation.getInstance().getGameSpecificMessage().equals("RRR")) {
			ourSwitchL = !alliance;
			ourSwitchR = alliance;
			scaleL = !alliance;
			scaleR = alliance;
			theirSwitchL = !alliance;
			theirSwitchR = alliance;
		} else if (DriverStation.getInstance().getGameSpecificMessage().equals("LRR")) {
			ourSwitchL = alliance;
			ourSwitchR = !alliance;
			scaleL = !alliance;
			scaleR = alliance;
			theirSwitchL = !alliance;
			theirSwitchR = alliance;

		} else if (DriverStation.getInstance().getGameSpecificMessage().equals("RLL")) {
			ourSwitchL = !alliance;
			ourSwitchR = alliance;
			scaleL = alliance;
			scaleR = !alliance;
			theirSwitchL = alliance;
			theirSwitchR = !alliance;
		} else if (DriverStation.getInstance().getGameSpecificMessage().equals("RLR")) {
			ourSwitchL = !alliance;
			ourSwitchR = alliance;
			scaleL = alliance;
			scaleR = !alliance;
			theirSwitchL = !alliance;
			theirSwitchR = alliance;
		} else if (DriverStation.getInstance().getGameSpecificMessage().equals("LRL")) {
			ourSwitchL = alliance;
			ourSwitchR = !alliance;
			scaleL = !alliance;
			scaleR = alliance;
			theirSwitchL = alliance;
			theirSwitchR = !alliance;
		} else if (DriverStation.getInstance().getGameSpecificMessage().equals("LLR")) {
			ourSwitchL = alliance;
			ourSwitchR = !alliance;
			scaleL = alliance;
			scaleR = !alliance;
			theirSwitchL = !alliance;
			theirSwitchR = alliance;
		} else if (DriverStation.getInstance().getGameSpecificMessage().equals("RRL")) {
			ourSwitchL = !alliance;
			ourSwitchR = alliance;
			scaleL = !alliance;
			scaleR = alliance;
			theirSwitchL = alliance;
			theirSwitchR = !alliance;
		}
		SmartDashboard.putNumber("Left Wheels Positon: ", driveSystem.getLeftPosition());
		SmartDashboard.putNumber("Left Wheels Distance Traveled: ", -driveSystem.getLeftPosition() / 217.40);
		SmartDashboard.putNumber("Right Wheels Positon: ", driveSystem.getRightPosition());
		SmartDashboard.putNumber("Right Wheels Distance Traveled: ", -driveSystem.getRightPosition() / 217.40);
		SmartDashboard.putNumber("Match Number: ", DriverStation.getInstance().getMatchNumber());
		SmartDashboard.putNumber("Time Left: ", DriverStation.getInstance().getMatchTime());
		SmartDashboard.putNumber("Driver Station Position: ", DriverStation.getInstance().getLocation());
		SmartDashboard.putBoolean(" Autonomous Mode ", DriverStation.getInstance().isAutonomous());
		SmartDashboard.putBoolean(" Operator Control ", DriverStation.getInstance().isOperatorControl());
		SmartDashboard.putBoolean(" Alliance ", alliance);
		SmartDashboard.putString("Match Type: ", DriverStation.getInstance().getMatchType().toString());
		SmartDashboard.putBoolean("Our Switch L", ourSwitchL);
		SmartDashboard.putBoolean("Our Switch R", ourSwitchR);
		SmartDashboard.putBoolean("Scale L", scaleL);
		SmartDashboard.putBoolean("Scale R", scaleR);
		SmartDashboard.putBoolean("Their Switch L", theirSwitchL);
		SmartDashboard.putBoolean("Their Switch R", theirSwitchR);
//		SmartDashboard.putNumber("Rotation", Robot.ahrs.getFusedHeading());
	}
}
