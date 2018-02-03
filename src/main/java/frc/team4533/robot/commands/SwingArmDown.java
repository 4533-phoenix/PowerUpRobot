package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class SwingArmDown extends Command {


	public SwingArmDown(){
		requires(SwingArmSystem.getInstance());
	}

	protected void initialize() {
		SwingArmSystem.getInstance().enable();
	}
	
	public void execute() {
		SwingArmSystem.getInstance().setAngle(20);
	}

	public void end() {
		SwingArmSystem.getInstance().disable();
		SwingArmSystem.getInstance().stop();
	}
	
	public void interrupted() {
		end();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
