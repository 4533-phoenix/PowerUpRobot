package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.subsystems.IntakeSystem;

public class PushOut extends Command {


	public PushOut(){
		requires(IntakeSystem.getInstance());
	}

	public void execute(){
		IntakeSystem.getInstance().out();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
