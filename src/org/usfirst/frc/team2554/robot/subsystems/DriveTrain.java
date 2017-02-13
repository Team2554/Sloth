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

		//if both are going in different directions
		if(checkSign(oi.getRawAxis(oi.stickLeftY)) == -checkSign(oi.controller.getRawAxis(oi.stickRightY))){
			if(oi.getAbsRawAxis(oi.stickLeftY) > DEADZONE && oi.getAbsRawAxis(oi.stickRightY) > DEADZONE){
				averageZaxisMag = (oi.getRawAxis(oi.stickLeftY) - oi.getRawAxis(oi.stickRightY))/2.0;
			}
			else
				averageZaxisMag = 0;
			drive(0, 0, averageZaxisMag/5);
		}
		//if both are going in same directions
		if(checkSign(oi.getRawAxis(oi.stickLeftX)) == checkSign(oi.getRawAxis(oi.stickRightX))){
			if(oi.getAbsRawAxis(oi.stickLeftY) > DEADZONE && oi.getAbsRawAxis(oi.stickRightX) > DEADZONE)
				averageXaxisMag = (oi.getRawAxis(oi.stickLeftX)+oi.getRawAxis(oi.stickRightX))/2.0;
			else {
				averageXaxisMag = 0;
				if(oi.getAbsRawAxis(oi.stickLeftY) > DEADZONE && oi.getAbsRawAxis(oi.stickRightX) > DEADZONE)
					averageYaxisMag = (oi.getRawAxis(oi.stickLeftY)+oi.getRawAxis(oi.stickRightY))/2.0;
				else
					averageYaxisMag = 0;
				drive(averageXaxisMag/5, averageYaxisMag/5, 0);
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
