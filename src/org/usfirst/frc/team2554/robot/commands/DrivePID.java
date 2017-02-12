package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
public class DrivePID extends PIDCommand{

	public DrivePID() {
		//Tune values
		super("Drive", 0, 0, 0);
	}

	@Override
	protected double returnPIDInput() {
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
    // Called just before this Command runs the first time
    protected void initialize() {
    	//Change point
    	setSetpoint(0);

    }
    
    // Called once after isFinished returns true
    protected void end() {
    	super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
