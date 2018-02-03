package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.subsystems.IntakeSystem;

public class TakeIn extends Command {


	public TakeIn(){
		requires(IntakeSystem.getInstance());
	}

	public void execute(){
		IntakeSystem.getInstance().in();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
