package frc.team4533.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4533.robot.RobotMap;

public class IntakeSystem extends Subsystem {
	
	private VictorSPX leftMotor;
	private VictorSPX rightMotor;
	private static IntakeSystem INSTANCE;
	
	public IntakeSystem() {
		leftMotor = new VictorSPX(RobotMap.INTAKE_LEFT);
		rightMotor = new VictorSPX(RobotMap.INTAKE_RIGHT);
	}
	
	public static void initialize() {
		if(INSTANCE == null) {
			INSTANCE = new IntakeSystem();
		}
	}
	
	public static IntakeSystem getInstance() {
		return INSTANCE;
	}
	
	public void in() {
		leftMotor.set(ControlMode.PercentOutput, 1);
		rightMotor.set(ControlMode.PercentOutput, 1);
	}
	
	public void out() {
		leftMotor.set(ControlMode.PercentOutput, -1);
		rightMotor.set(ControlMode.PercentOutput, -1);
	}
	
	public void stop() {
		leftMotor.set(ControlMode.PercentOutput, 0);
		rightMotor.set(ControlMode.PercentOutput, 0);
	}
	
	public boolean hasCube() {
		//if(proximitySensor detects cube) {
		//	return true;
		//}
		return false;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
