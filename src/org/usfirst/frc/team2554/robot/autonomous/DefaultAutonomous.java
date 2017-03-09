package org.usfirst.frc.team2554.robot.autonomous;

import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class DefaultAutonomous extends Command {
	RobotDrive myRobot;
    Timer timer = new Timer();
	public DefaultAutonomous(RobotDrive robot) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		myRobot = robot;
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	myRobot.drive(0,0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() < 15;	
    }

    // Called once after isFinished returns true
    protected void end() {
    	myRobot.drive(0, 0);
    	timer.stop();
    }
    
    // Called once this Command is canceled
    public void cancel(){
    	myRobot.drive(0, 0);
    	timer.stop();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	timer.stop();
    }
}
