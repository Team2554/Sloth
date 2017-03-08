package org.usfirst.frc.team2554.robot.autonomous;

import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterGearAutonomous extends Command {
	RobotDrive myRobot = new RobotDrive(RobotMap.driveTrain[0], RobotMap.driveTrain[1], RobotMap.driveTrain[2], RobotMap.driveTrain[3]);
    Timer timer = new Timer();
    public CenterGearAutonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	myRobot.drive(0, 0);
    	myRobot.drive(0.5, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Change delay
        return timer.get() < 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	myRobot.drive(0,0);
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	myRobot.drive(0, 0);
    	timer.stop();
    }
}
