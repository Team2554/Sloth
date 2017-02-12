package org.usfirst.frc.team2554.robot.subsystems;

import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends Subsystem {
	Victor feeder = new Victor(RobotMap.hopper);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		stop();
    }
    
    public void spin(double speed){
    	feeder.set(speed);
    }
    public void stop(){
    	feeder.set(0);
    }
}

