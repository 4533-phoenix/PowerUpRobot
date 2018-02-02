package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.subsystems.IntakeSystem;

public class IntakeCommand extends Command {
	
	Joystick j;
	IntakeSystem intakeSystem;
	
	public IntakeCommand() {
		intakeSystem = IntakeSystem.getInstance();
		j = new Joystick(RobotMap.JOYSTICK_PORT);
	}
	
	public void execute() {
		if(j.getRawButton(RobotMap.LEFT_TRIGGER)) {
			intakeSystem.in();
		}
		if(j.getRawButtonPressed(RobotMap.RIGHT_TRIGGER)) {
			intakeSystem.out();
		}
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
