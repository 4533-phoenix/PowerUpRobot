package frc.team4533.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExtraButtonCommand extends CommandGroup {
    public ExtraButtonCommand() {
        this.addParallel(new Stop(), 1);
    }
}
