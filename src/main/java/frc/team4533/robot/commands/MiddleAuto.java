package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleAuto extends CommandGroup {

    public MiddleAuto(String gameData) {
        this.addSequential(new DriveDistance(10));
        if(gameData.substring(0,1).equals("L")) {
            this.addSequential(new AngleTurn(-(90-66.03)));
        }
        else {
            this.addSequential(new AngleTurn(90-66.03));
        }
        this.addSequential(new DriveDistance(60));
        this.addSequential(new PushOut(.4));
    }
}
