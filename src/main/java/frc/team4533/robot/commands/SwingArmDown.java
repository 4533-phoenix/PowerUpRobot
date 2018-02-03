package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class SwingArmDown extends Command {


	public SwingArmDown(){
		requires(SwingArmSystem.getInstance());
	}

	public void execute(){
		SwingArmSystem.getInstance().down();
	}

	public void end() {
		SwingArmSystem.getInstance().stop();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
