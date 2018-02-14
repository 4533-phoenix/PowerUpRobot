package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.subsystems.DriveSystem;

public class Stop extends Command {

	public Stop() {
		
	}
	public void execute() {
		DriveSystem.getInstance().stop();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
