package frc.team4533.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4533.robot.commands.MoveSwingArm;
import frc.team4533.robot.commands.PushOut;
import frc.team4533.robot.commands.SwingArmDown;
import frc.team4533.robot.commands.TakeIn;
import frc.team4533.robot.subsystems.IntakeSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;
/**
 * The place where buttons are mapped to commands
 * @author 4533 Programming Team
 *
 */
public class OI {
	private Joystick j = new Joystick(RobotMap.JOYSTICK_PORT);
	private static OI INSTANCE;
	private JoystickButton intakeIn = new JoystickButton(j, RobotMap.LEFT_BUMPER);
	private JoystickButton intakeOut = new JoystickButton(j, RobotMap.LEFT_TRIGGER);
	private JoystickButton arm55 = new JoystickButton(j, RobotMap.Y_BUTTON);
	private JoystickButton arm15 = new JoystickButton(j, RobotMap.X_BUTTON);
	private JoystickButton arm20 = new JoystickButton(j, RobotMap.B_BUTTON);
	private JoystickButton arm5 = new JoystickButton(j, RobotMap.A_BUTTON);
	
	/**
	 * Creates the controls for the robots
	 */
	public OI(){
		IntakeSystem.initialize();
		SwingArmSystem.initialize();
		intakeIn.whileHeld(new TakeIn());
		intakeOut.whileHeld(new PushOut());
		arm55.whenPressed(new MoveSwingArm(55));
		//When intake detected move to 10
		arm5.whenPressed(new MoveSwingArm(5));
		arm15.whenPressed(new MoveSwingArm(15));
		arm20.whenPressed(new MoveSwingArm(20));
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
