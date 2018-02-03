package frc.team4533.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4533.robot.RobotMap;

public class SwingArmSystem extends PIDSubsystem {
	
	private VictorSPX motor;
	private AnalogInput potentiometer;
	public static SwingArmSystem INSTANCE;
	
	public SwingArmSystem() {
		super(0.08, 0.0, 0.0);
		motor = new VictorSPX(RobotMap.SWING_ARM_MOTOR);
		potentiometer = new AnalogInput(RobotMap.SWING_ARM_POTENTIOMETER);
		getPIDController().setContinuous(false);
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
		motor.set(ControlMode.PercentOutput, .5);
	}
	
	public void down() {
		motor.set(ControlMode.PercentOutput, -.5);
	}
	
	public void stop() {
		motor.set(ControlMode.PercentOutput, 0);
	}
	
	public double position() {
		return potentiometer.getValue();
	}
	
	public double angle() {
		return .04 * (this.position())-8.10;
	}
	@Override
	protected void initDefaultCommand() {

		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return this.angle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		motor.set(ControlMode.PercentOutput, output);
	}
	
	public void setAngle(double angle) {
		this.setSetpoint(angle);
	}
}
