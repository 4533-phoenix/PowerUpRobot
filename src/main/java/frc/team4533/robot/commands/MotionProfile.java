package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4533.robot.subsystems.DriveSystem;
/**
 * The command that makes the robot drive to a certain distance
 * @author 4533 Programming Team
 *
 */
public class MotionProfile extends Command {

    private DriveSystem driveSystem = DriveSystem.getInstance();
    private double[][] leftProfile;
    private double[][] rightProfile;
    private static final double CIRCUMFERENCE = 6*Math.PI;
    private static final double UNITS_PER_INCH = DriveSystem.UNITS_PER_REVOLUTION/CIRCUMFERENCE;

    public MotionProfile(double[][] lprofile,double[][] rprofile) {
        this.requires(driveSystem);
        this.leftProfile = lprofile;
        this.rightProfile = rprofile;
        DriveSystem.getInstance().setPeakOutput(.3);
        driveSystem.startFilling(leftProfile,leftProfile.length,false);
        driveSystem.startFilling(rightProfile,rightProfile.length,true);

    }

    public void execute() {
        DriveSystem.getInstance().setPIDFValues(0.1, 0.0001, 0, 0);
        driveSystem.driveMotionProfile(leftProfile.length,false);

        driveSystem.driveMotionProfile(rightProfile.length,true);
    }

    @Override
    protected boolean isFinished() {
        return (Math.abs(driveSystem.getLeftPosition()) >= leftProfile[leftProfile.length-1][0]) && (Math.abs(driveSystem.getRightPosition()) >= rightProfile[rightProfile.length-1][0]);
    }

    public void end() {
        driveSystem.setPosition(0);
        driveSystem.stop();
    }

}
