package org.usfirst.frc.team2554.robot.commands;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SwitchCamera extends InstantCommand {

    public SwitchCamera() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
       requires(Robot.camera);
    }

    // Called once when the command executes
    protected void initialize() {
    //	Robot.camera.switchCam();
    }

}
