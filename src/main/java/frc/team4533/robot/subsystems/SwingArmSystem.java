package frc.team4533.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class SwingArmSystem extends Subsystem {
	
	private VictorSPX motor;
	public static SwingArmSystem INSTANCE;
	
	public SwingArmSystem() {
		motor = new VictorSPX(4);
	}
	
	public static void initialize() {
		if(INSTANCE == null) {
			INSTANCE = new SwingArmSystem();
		}
	}
	
	public SwingArmSystem getInstance() {
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
		// TODO Auto-generated method stub
		
	}

}
