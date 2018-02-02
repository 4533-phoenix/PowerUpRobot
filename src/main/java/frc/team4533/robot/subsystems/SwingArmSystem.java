package frc.team4533.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.commands.SwingArmUp;

public class SwingArmSystem extends Subsystem {
	
	private VictorSPX motor;
	public static SwingArmSystem INSTANCE;
	private SwingArmUp swingArmCommand;
	
	public SwingArmSystem() {
		motor = new VictorSPX(RobotMap.SWING_ARM_MOTOR);
		swingArmCommand=new SwingArmUp();
	}
	
	public static void initialize() {
		if(INSTANCE == null) {
			INSTANCE = new SwingArmSystem();
		}
	}
	
	public static SwingArmSystem getInstance() {
		return INSTANCE;
	}
	
	public void up() {
		motor.set(ControlMode.PercentOutput, 1);
	}
	
	public void down() {
		motor.set(ControlMode.PercentOutput, -1);
	}
	
	public void stop() {
		motor.set(ControlMode.PercentOutput, 0);
	}
	
	public double position() {
		//returning 0.0 until we have a position
		return 0.0;
	}
	@Override
	protected void initDefaultCommand() {

		this.setDefaultCommand(swingArmCommand);
		
	}

}
