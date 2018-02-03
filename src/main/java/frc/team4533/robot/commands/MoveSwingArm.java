package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class MoveSwingArm extends Command {

	double targetAngle;
	
	
	public MoveSwingArm(double angle){
		requires(SwingArmSystem.getInstance());
		targetAngle = angle;
	}

	protected void initialize() {
		SwingArmSystem.getInstance().enable();
	}
	
	public void execute() {
		SwingArmSystem.getInstance().setAngle(targetAngle);
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
