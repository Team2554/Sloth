package org.usfirst.frc.team2554.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
/**
 *
 */
public class Shooter extends Subsystem {
	double speed = 0;
	Victor shooterL = new Victor(RobotMap.shooterL);
	Victor shooterR = new Victor(RobotMap.shooterR);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void spin(){
    	//PID will be here
    	shooterL.set(speed);
    	shooterR.set(speed);
    }
    public void rev(){
    	//revs up the shooter
    	//PID will go here
    	shooterL.set(speed);
    	shooterR.set(speed);
    }
    public void stop(){
    	shooterL.set(0);
    	shooterR.set(0);
    }
}

