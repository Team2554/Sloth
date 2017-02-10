package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinHopper extends Command {

    public SpinHopper() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.hopper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.hopper.spin();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.oi.controller.getRawAxis(Robot.oi.ryAxis) == 0)
    		return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.hopper.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}