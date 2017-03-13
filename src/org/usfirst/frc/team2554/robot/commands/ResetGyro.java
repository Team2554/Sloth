package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ResetGyro extends InstantCommand {
//	double degrees;
	
    public ResetGyro(/*double deg*/) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//        degrees = deg;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.gyro.reset();
    }

}
