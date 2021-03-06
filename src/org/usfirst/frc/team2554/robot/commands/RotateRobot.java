package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateRobot extends Command {

	//Check the center pixel. Either 320 or 0
	//Camera is 640 x 480
	double center = 320;
    public RotateRobot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.liftTracker);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    public void start(){
    	double pos = 0;//Robot.liftTracker.returnWeightedX();
    	
    	if(pos > center)
    		Robot.rotationValue = 0.4;
    	else if(pos < center)
    		Robot.rotationValue = -0.4;
    	else
    		Robot.rotationValue = 0;
    }
    public void cancel(){
    	Robot.rotationValue = 0;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double pos =0;//Robot.liftTracker.returnWeightedX();
    	Robot.rotationValue = Robot.checkSign(pos)/2.0;
    	//System.out.println( "returnWeightedX" + Robot.liftTracker.returnWeightedX() );
}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double pos = 0;//Robot.liftTracker.returnWeightedX();
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
