package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.subsystems.DriveSystem;
import frc.team4533.robot.subsystems.IntakeSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;

/**
 * Stops the robot from moving.
 * @author 4533 Programming Team
 *
 */
public class Stop extends Command {

	public Stop() {
		
	}
	public void execute() {
		DriveSystem.getInstance().stop();
		IntakeSystem.getInstance().stop();
		SwingArmSystem.getInstance().stop();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
