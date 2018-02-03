package frc.team4533.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4533.robot.commands.TakeIn;
import frc.team4533.robot.commands.PushOut;
import frc.team4533.robot.commands.SwingArmUp;
import frc.team4533.robot.commands.SwingArmDown;
import frc.team4533.robot.subsystems.IntakeSystem;
import frc.team4533.robot.subsystems.SwingArmSystem;

public class OI {
	Joystick j = new Joystick(RobotMap.JOYSTICK_PORT);
	private static OI INSTANCE;
	JoystickButton intakeIn=new JoystickButton(j,RobotMap.LEFT_BUMPER);
	JoystickButton intakeOut=new JoystickButton(j,RobotMap.LEFT_TRIGGER);
	JoystickButton armUp=new JoystickButton(j,RobotMap.RIGHT_BUMPER);
	JoystickButton armDown=new JoystickButton(j,RobotMap.RIGHT_TRIGGER);
	public OI(){
		IntakeSystem.initialize();
		SwingArmSystem.initialize();
		intakeIn.whileHeld(new TakeIn());
		intakeOut.whileHeld(new PushOut());
		armUp.whenPressed(new SwingArmUp());
		armDown.whenPressed(new SwingArmDown());
	}
	public static OI getInstance() {
		return INSTANCE;
	}
	public static void initialize() {
		if(INSTANCE == null) {
			INSTANCE = new OI();
		}
	}
}
