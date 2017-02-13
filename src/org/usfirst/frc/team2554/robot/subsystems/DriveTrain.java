package org.usfirst.frc.team2554.robot.subsystems;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.RobotMap;
import org.usfirst.frc.team2554.robot.OI;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    double averageXaxisMag, averageYaxisMag, averageZaxisMag;
    OI oi = Robot.oi;
    static final double DEADZONE = Robot.DEADZONE;
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	RobotDrive myRobot = new RobotDrive(RobotMap.driveTrain[0], RobotMap.driveTrain[1], RobotMap.driveTrain[2], RobotMap.driveTrain[3]);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		stop();
	}
	public void mecaDrive(){
		//Code will be here. Arjun please find it.

		if(checkSign(oi.getRawAxis(oi.stickLeftY)) == -checkSign(oi.controller.getRawAxis(oi.stickRightY))){
			if(oi.controller.getRawAxis(oi.stickLeftY) > DEADZONE && oi.controller.getRawAxis(oi.stickRightY) > DEADZONE){
				averageYaxisMag = (oi.controller.getRawAxis(oi.stickLeftY) - oi.controller.getRawAxis(oi.stickRightY))/2.0;
			}
			else
				averageYaxisMag = 0;
			myRobot.mecanumDrive_Cartesian(0, 0, averageYaxisMag/5, 0);
		}
		//if both are going in same directions
		if(checkSign(oi.controller.getRawAxis(oi.stickLeftX)) == checkSign(oi.controller.getRawAxis(oi.stickRightX))){
			if(oi.controller.getRawAxis(oi.stickLeftY) > DEADZONE && oi.controller.getRawAxis(oi.stickRightX) > DEADZONE)
				averageXaxisMag = (oi.controller.getRawAxis(oi.stickLeftX)+oi.controller.getRawAxis(oi.stickRightX))/2.0;
			else {
				averageXaxisMag = 0;
				if(oi.controller.getRawAxis(oi.stickLeftY) > DEADZONE && oi.controller.getRawAxis(oi.stickRightX) > DEADZONE)
					averageYaxisMag = (oi.controller.getRawAxis(oi.stickLeftY)+oi.controller.getRawAxis(oi.stickRightY))/2.0;
				else
					averageYaxisMag = 0;
				myRobot.mecanumDrive_Cartesian(averageXaxisMag/5, averageYaxisMag/5, 0, 0);
			}
		}

		//I tried my best
	}
	public void drive(double x, double y, double rotation){
		myRobot.mecanumDrive_Cartesian(x, y, rotation, Robot.gyro.getAngle());
	}
	public void stop(){
		myRobot.drive(0, 0);
	}
	public int checkSign(double checkNum){
		if(checkNum < 0)
			return -1;
		if(checkNum > 0)
			return 1;
		return 0;
	}
}
