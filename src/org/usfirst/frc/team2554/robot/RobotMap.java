package org.usfirst.frc.team2554.robot;

import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//2 DOES NOT WORK
	//Front Left, Back Left, Front Right, Back Right
	final public static int driveTrain[] = {0,1,4,3};
	//Arbitrary Numbers
	final public static int shooterL = 6; //bottom shooter 
	final public static int shooterR = 5; //upper shooter
	final public static int intake = 7;
	final public static int hopper = 8;
	final public static int climber = 9; //this is a spark

//	final public static int intake = 5;
//	final public static int shooterL = 6;
//	final public static int shooterR = 7;
	
	//Limit Switch DIO
	final public static int limitSwitchFeeder = 0;
	final public static int shooterEncoderA = 1;
	final public static int shooterEncoderB = 2;
	final public static int lights = 0;
	
	//Camera
	//public static MjpegServer outputServer= new MjpegServer("serve_camera", 1181);
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
