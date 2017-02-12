package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AdjustFeeder extends Command {

    public AdjustFeeder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    protected void execute() {
		Robot.feeder.spin(0.1);
}
// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Adjust Time Constant
    	return Robot.feederSwitch.get() || Robot.timer.hasPeriodPassed(5);
    }

// Called once after isFinished returns true
    protected void end() {
    	Robot.feeder.stop();
    }

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
    protected void interrupted() {
	Robot.feeder.stop();
    }
}
