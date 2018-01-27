package frc.team4533.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4533.robot.RobotMap;
import frc.team4533.robot.commands.DriveCommand;

public class DriveSystem extends Subsystem {

	private static DriveSystem INSTANCE;
	WPI_TalonSRX leftMaster;
	WPI_TalonSRX leftSlave;
	WPI_TalonSRX rightMaster;
	WPI_TalonSRX rightSlave;
	private static final int MAX_VELOCITY = 250;
	public static final int UNITS_PER_REVOLUTION = 4096;
	private static final int TIMEOUT = 10;
	private static final int DEFAULT_PID_INDEX = 0;

	public DriveSystem() {
		rightMaster = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_MASTER);
		leftMaster = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_MASTER);
		rightSlave = new WPI_TalonSRX(RobotMap.MOTOR_RIGHT_SLAVE);
		leftSlave = new WPI_TalonSRX(RobotMap.MOTOR_LEFT_SLAVE);

		leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, DEFAULT_PID_INDEX, TIMEOUT);
		leftMaster.setSensorPhase(true);

		leftMaster.configNominalOutputForward(0, TIMEOUT);
		leftMaster.configNominalOutputReverse(0, TIMEOUT);
		leftMaster.configPeakOutputForward(0.5, TIMEOUT);
		leftMaster.configPeakOutputReverse(-0.5, TIMEOUT);

		rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, DEFAULT_PID_INDEX, TIMEOUT);
		rightMaster.setSensorPhase(true);

		rightMaster.configNominalOutputForward(0, TIMEOUT);
		rightMaster.configNominalOutputReverse(0, TIMEOUT);
		rightMaster.configPeakOutputForward(0.5, TIMEOUT);
		rightMaster.configPeakOutputReverse(-0.5, TIMEOUT);

		leftMaster.setInverted(true);
		leftSlave.setInverted(true);
	}

	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new DriveSystem();
		}
	}

	public static DriveSystem getInstance() {
		return INSTANCE;
	}

	public void setPIDFValues(double p, double i, double d, double f) {
		leftMaster.config_kF(DEFAULT_PID_INDEX, f, TIMEOUT);
		leftMaster.config_kP(DEFAULT_PID_INDEX, p, TIMEOUT);
		leftMaster.config_kI(DEFAULT_PID_INDEX, i, TIMEOUT);
		leftMaster.config_kD(DEFAULT_PID_INDEX, d, TIMEOUT);
		rightMaster.config_kF(DEFAULT_PID_INDEX, f, TIMEOUT);
		rightMaster.config_kP(DEFAULT_PID_INDEX, p, TIMEOUT);
		rightMaster.config_kI(DEFAULT_PID_INDEX, i, TIMEOUT);
		rightMaster.config_kD(DEFAULT_PID_INDEX, d, TIMEOUT);
	}

	public void driveAction(double left, double right) {
		// This method used to actually drive the robot
		this.leftMaster.set(left);
		this.rightMaster.set(right);
		this.leftSlave.set(ControlMode.Follower, RobotMap.MOTOR_LEFT_MASTER);
		this.rightSlave.set(ControlMode.Follower, RobotMap.MOTOR_RIGHT_MASTER);
	}

	public void driveVelocity(double left, double right) {
		double targetL = left * MAX_VELOCITY * UNITS_PER_REVOLUTION / 600;
		double targetR = right * MAX_VELOCITY * UNITS_PER_REVOLUTION / 600;
		leftMaster.set(ControlMode.Velocity, targetL);
		rightMaster.set(ControlMode.Velocity, targetR);
		leftSlave.set(ControlMode.Follower, RobotMap.MOTOR_LEFT_MASTER);
		rightSlave.set(ControlMode.Follower, RobotMap.MOTOR_RIGHT_MASTER);
	}
	
	public void drivePosition(int position) {
		leftMaster.set(ControlMode.Position, position);
		rightMaster.set(ControlMode.Position, position);
		leftSlave.set(ControlMode.Follower, RobotMap.MOTOR_LEFT_MASTER);
		rightSlave.set(ControlMode.Follower, RobotMap.MOTOR_RIGHT_MASTER);
	}

	public void initDefaultCommand() {
		this.setDefaultCommand(new DriveCommand());
	}
	// Just some methods we can use in autonomous

	public void forward(double v) {
		this.driveAction(v, v);
	}

	public void backward(double v) {
		this.driveAction(v, v);
	}

	public void stop() {
		this.driveAction(0.0, 0.0);
	}

	public void turn(double v, double w) {
		this.driveAction(v, w);
	}
	
	public void setPosition(int position) {
		leftMaster.setSelectedSensorPosition(position, DEFAULT_PID_INDEX, TIMEOUT);
		rightMaster.setSelectedSensorPosition(position, DEFAULT_PID_INDEX, TIMEOUT);
	}
	
	public int getLeftPosition() {
		return leftMaster.getSelectedSensorPosition(DEFAULT_PID_INDEX);
	}
	
	public int getRightPosition() {
		return rightMaster.getSelectedSensorPosition(DEFAULT_PID_INDEX);
	}
}
