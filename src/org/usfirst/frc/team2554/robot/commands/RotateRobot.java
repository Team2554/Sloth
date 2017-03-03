package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateRobot extends Command {

    public RotateRobot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double pos = Robot.lifttracker.returnWeightedX();
    	Robot.rotationValue = pos;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double pos = Robot.lifttracker.returnWeightedX();
    	if( pos < 0.05 && pos > -0.05 )
    		return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
