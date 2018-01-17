package org.usfirst.frc.team4533.robot.subsystems;

import org.usfirst.frc.team4533.robot.RobotMap;
import org.usfirst.frc.team4533.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSystem extends Subsystem {
	
	private static IntakeSystem INSTANCE;
	VictorSPX intakeMotor;
	
	public IntakeSystem() {
		intakeMotor = new VictorSPX(RobotMap.MOTOR_INTAKE);
	}
	public static void initialize() {
		if(INSTANCE == null) {
			INSTANCE = new IntakeSystem();
		}
	}
	public static IntakeSystem getInstance() {
		return INSTANCE;
	}
	public void IntakeAction(int percentOutput) {
		this.intakeMotor.set(ControlMode.PercentOutput, percentOutput);
	}
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
