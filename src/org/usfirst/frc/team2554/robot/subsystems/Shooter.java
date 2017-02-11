package org.usfirst.frc.team2554.robot.subsystems;

import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Shooter extends PIDSubsystem {
	double speed = 0;
	Victor shooterL = new Victor(RobotMap.shooterL);
	Victor shooterR = new Victor(RobotMap.shooterR);
    // Initialize your subsystem here
    public Shooter() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("Shooter",0,0,0);
    	setAbsoluteTolerance(0.01);
    	//Requires range. One of the boundaries should be 0.
    	setOutputRange(-1,1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	speed = output;
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void spin(){
    	shooterL.set(speed);
    	shooterR.set(speed);
    }
    public void spin(double speed){
    	shooterL.set(speed);
    	shooterR.set(speed);
    }
    public void stop(){
    	shooterL.set(0);
    	shooterR.set(0);
    }
    public void enablePID(){
    	enable();
    }
    public void disablePID(){
    	disable();
    }
    public boolean isTarget(){
    	return onTarget();
    }
}
