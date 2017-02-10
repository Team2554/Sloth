//DEPRECATED

package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MecaDrive extends Command {
    double averageXaxisMag, averageYaxisMag;
    final double DEADZONE = 0.15;
    public MecaDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(checkSign(Robot.oi.controller.getRawAxis(Robot.oi.stickLeftY)) == -checkSign(Robot.oi.controller.getRawAxis(Robot.oi.stickRightY))){
			if(Robot.oi.controller.getRawAxis(Robot.oi.stickLeftY) > DEADZONE && Robot.oi.controller.getRawAxis(Robot.oi.stickRightY) > DEADZONE){
				averageYaxisMag = (Robot.oi.controller.getRawAxis(Robot.oi.stickLeftY)-Robot.oi.controller.getRawAxis(Robot.oi.stickRightY))/2.0;
			}
			else
				averageYaxisMag = 0;
		}
		//if both are gRobot.oing in same directRobot.oins
		if(checkSign(Robot.oi.controller.getRawAxis(Robot.oi.stickLeftX)) == checkSign(Robot.oi.controller.getRawAxis(Robot.oi.stickRightX))){
			if(Robot.oi.controller.getRawAxis(Robot.oi.stickLeftY) > DEADZONE && Robot.oi.controller.getRawAxis(Robot.oi.stickRightX) > DEADZONE)
				averageXaxisMag = (Robot.oi.controller.getRawAxis(Robot.oi.stickLeftX)+Robot.oi.controller.getRawAxis(Robot.oi.stickRightX))/2.0;
			else
				averageXaxisMag = 0;
			if(Robot.oi.controller.getRawAxis(Robot.oi.stickLeftY) > DEADZONE && Robot.oi.controller.getRawAxis(Robot.oi.stickRightX) > DEADZONE)
				averageYaxisMag = (Robot.oi.controller.getRawAxis(Robot.oi.stickLeftY)+Robot.oi.controller.getRawAxis(Robot.oi.stickRightY))/2.0;
			else
				averageYaxisMag = 0;
		}
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
	public int checkSign(double checkNum){
		if(checkNum < 0)
			return -1;
		if(checkNum > 0)
			return 1;
		return 0;
	}
}
