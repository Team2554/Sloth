package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinIntake extends Command {

    public SpinIntake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    public void start(){
    	Robot.intake.spin(1.0);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Deprecated
    	//Bound to Trigger
    	//if(Robot.oi.controller.getRawAxis(Robot.oi.lyAxis) == 0)
    	//	return true;
        return false;
    }

    public void cancel(){
    	Robot.intake.stop();
    }
    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stop();
    }
}
