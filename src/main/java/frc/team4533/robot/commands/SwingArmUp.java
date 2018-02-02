package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class SwingArmUp extends Command {


	public SwingArmUp(){
		requires(SwingArmSystem.getInstance());
	}

	public void execute(){
		SwingArmSystem.getInstance().up();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
