package frc.team4533.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4533.robot.commands.MoveSwingArm;
import frc.team4533.robot.commands.PushOut;
import frc.team4533.robot.commands.SwingArmDown;
import frc.team4533.robot.commands.TakeIn;
import frc.team4533.robot.subsystems.IntakeSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class OI {
	Joystick j = new Joystick(RobotMap.JOYSTICK_PORT);
	private static OI INSTANCE;
	private JoystickButton intakeIn = new JoystickButton(j, RobotMap.LEFT_BUMPER);
	private JoystickButton intakeOut = new JoystickButton(j, RobotMap.LEFT_TRIGGER);
	private JoystickButton armUp = new JoystickButton(j, RobotMap.RIGHT_BUMPER);
	private JoystickButton armDown = new JoystickButton(j, RobotMap.RIGHT_TRIGGER);
	
	/**
	 * Creates the controls for the robots
	 */
	public OI(){
		IntakeSystem.initialize();
		SwingArmSystem.initialize();
		intakeIn.whileHeld(new TakeIn());
		intakeOut.whileHeld(new PushOut());
		armUp.whenPressed(new MoveSwingArm(45));
		armDown.whenPressed(new MoveSwingArm(5));
	}
	/**
	 * @return Instance: An instance of OI
	 */
	public static OI getInstance() {
		return INSTANCE;
	}
	/**
	 * Initializes OI
	 */
	public static void initialize() {
		if (INSTANCE == null) {
			INSTANCE = new OI();
		}
	}
}
