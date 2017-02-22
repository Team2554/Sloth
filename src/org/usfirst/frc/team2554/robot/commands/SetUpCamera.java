package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetUpCamera extends InstantCommand {

    public SetUpCamera() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.camera);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.camera.setUpCamServer();
    	Robot.camera.createSinks();
    	Robot.camera.createSource();
    }

}
