package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinFeeder extends Command {

    public SpinFeeder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.shooter.onTarget())
    		Robot.feeder.spin(0.6);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Deprecated
    	//Bound to Trigger
    	//if(Robot.oi.controller.getRawAxis(Robot.oi.ryAxis) == 0)
    	//	return true;
        return false;
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
