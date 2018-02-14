package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.subsystems.DriveSystem;

public class AngleTurn extends Command {
	
	double angle;
	
	public AngleTurn(double angle) {
		this.requires(DriveSystem.getInstance());
		this.angle = angle;
		DriveSystem.getInstance().resetAngle();
	}
	
	public void execute() {
		DriveSystem.getInstance().setPIDFValues(.15, 0, 2.5, 0.243);
		if(angle > 0) {
			DriveSystem.getInstance().driveVelocity(-.35, .35);
		}
		else if(angle < 0) {
			DriveSystem.getInstance().driveVelocity(.35, -.35);
		}
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Math.abs(DriveSystem.getInstance().getAngle()) >= Math.abs(angle);
	}
	public void end() {
		DriveSystem.getInstance().resetAngle();
		DriveSystem.getInstance().setPosition(0);
		DriveSystem.getInstance().stop();
	}
}
