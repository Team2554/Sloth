package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinShooter extends Command {

    public SpinShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    public void start(){
    	Robot.shooter.spin(0.6);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Deprecated
    	//Bound to Trigger
    	//if(Robot.oi.controller.getRawAxis(Robot.oi.ryAxis) == 0)
    	//	return true;
        return false;
    }

    public void cancel(){
    	Robot.shooter.stop();
    	Robot.shooter.disable();
    }
    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.stop();
    	Robot.shooter.disable();
    }
}