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

	double percent;
	public PushOut(double percent){
		this.percent = percent;
		requires(IntakeSystem.getInstance());
	}

	public void execute(){
		IntakeSystem.getInstance().out(percent);
	}

	public void end() {
		IntakeSystem.getInstance().stop();
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
