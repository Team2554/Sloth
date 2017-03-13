package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGyro extends Command {
	double myDeg;
	
    public ToggleGyro(int deg) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		myDeg = deg;	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    public void start() {
    	Robot.isGyroCommand = false;
<<<<<<< HEAD
    	Robot.gyroDegrees = 90.0;
=======
		Robot.gyroDegDefault = myDeg;
>>>>>>> origin/master
    }
    public void cancel() {
    	Robot.isGyroCommand = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
