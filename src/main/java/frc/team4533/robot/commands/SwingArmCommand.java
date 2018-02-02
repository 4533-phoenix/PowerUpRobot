package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class SwingArmCommand extends Command {
	
	private Joystick j;
	private SwingArmSystem swingArmSystem;
	
	public SwingArmCommand() {
		j = new Joystick(RobotMap.JOYSTICK_PORT);
		swingArmSystem = SwingArmSystem.getInstance();
	}
	
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
