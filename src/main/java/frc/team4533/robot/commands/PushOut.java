package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.subsystems.IntakeSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;
/**
 * The command that pushes the cube in the intake out.
 * @author 4533 Programming Team
 *
 */
public class PushOut extends Command {


	public PushOut(){
		requires(IntakeSystem.getInstance());
	}

	public void execute(){
		IntakeSystem.getInstance().out();
	}

	public void end() {
		IntakeSystem.getInstance().stop();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
