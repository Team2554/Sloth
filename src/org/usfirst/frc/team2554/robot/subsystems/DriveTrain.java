package org.usfirst.frc.team2554.robot.subsystems;

import org.usfirst.frc.team2554.robot.Robot;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    double averageXaxisMag, averageYaxisMag;
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
