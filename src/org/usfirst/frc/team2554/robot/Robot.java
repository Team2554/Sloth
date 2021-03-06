
package org.usfirst.frc.team2554.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team2554.robot.autonomous.*;
import org.usfirst.frc.team2554.robot.commands.*;
import org.usfirst.frc.team2554.robot.subsystems.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public double averageXaxisMag, averageYaxisMag, averageZaxisMag;
	public static final double DEADZONE = 0.15;
	public static double multiplier;
	public static OI oi;
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static Feeder feeder = new Feeder();
	public static Shooter shooter = new Shooter();
	public static Intake intake = new Intake();
	public static Climber climber = new Climber();
	public static DigitalInput feederSwitch = new DigitalInput(RobotMap.limitSwitchFeeder);
	public static Relay lights = new Relay(RobotMap.lights);
	public static Encoder shooterEncoder = new Encoder(RobotMap.shooterEncoderA, RobotMap.shooterEncoderB);
	public static LiftTracker liftTracker = new LiftTracker();
	public static NetworkTable gripTable;
	public static Camera camera;
	public static double rotationValue = 0.0;
	public static boolean isGyroCommand = true;
	public static double gyroDegDefault;
	Command autonomousCommand;
	public static double Xaxis, Yaxis, Zaxis;
	PIDController encoderController;
	Encoder encoder;
	Victor output;
	RobotDrive myRobot;
	public static ConditionalCommand adjustShooterConditional;
	SendableChooser<Command> chooser = new SendableChooser<>();
	public static Timer timer = new Timer();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture(0);
		CameraServer.getInstance().startAutomaticCapture(1);
		myRobot = new RobotDrive(RobotMap.driveTrain[0], RobotMap.driveTrain[1], RobotMap.driveTrain[2],
				RobotMap.driveTrain[3]);
		oi = new OI();
		gripTable = NetworkTable.getTable("GRIP/myContoursReport");
		camera = new Camera();
		// BUTTONS
		oi.climbButton.whileHeld(new ClimbUp());
		oi.shootingTrigger.whileActive(new SpinShooter());
		oi.feederTrigger.whileActive(new SpinFeederForward());
		oi.intakeButton.whileHeld(new SpinIntake());
		oi.feederBackButton.whileHeld(new SpinFeederBackward());
		oi.resetGyroButton.whenPressed(new ResetGyro());
		oi.toggleGyroButton.whileHeld(new ToggleGyro(90));
		oi.climbingViewButton.whileHeld(new ToggleGyro(270));
		adjustShooterConditional = new AdjustShootingConditional(new AdjustShootingGroup());
		chooser.addDefault("Default Auto", new DefaultAutonomous(myRobot));
		chooser.addObject("Center Gear", new CenterGearAutonomous(myRobot));
		SmartDashboard.putData("Auto mode", chooser);
		try {
	//		SmartDashboard.putNumber("returnWeightedX", liftTracker.returnWeightedX());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SmartDashboard.putBoolean("Is Gyro On", isGyroCommand);
		// CHANGE Distance Value
		shooterEncoder.setDistancePerPulse(1);
		timer.reset();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().removeAll();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		gyro.calibrate();
	//	autonomousCommand = chooser.getSelected();
		timer.start(); 

		//timer.delay(5.0);
		//myRobot.mecanumDrive_Cartesian(0, 0, 0, 0);
		// schedule the autonomous command (example)
		//if (autonomousCommand != null)
			//autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		if(timer.get() < 4)
			myRobot.mecanumDrive_Cartesian(-0.5, 0.0, 0, 0);
		else
			myRobot.mecanumDrive_Cartesian(0, 0, 0, 0);
	}

	@Override
	public void teleopInit() {
		timer.stop();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		myRobot.setSafetyEnabled(false);
	}

	/**
	 * 
	 * 
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	//	camera.outputVideo();
	//	if(oi.joystick.getRawButton(oi.bButton))
	//		camera.switchCam();
		multiplier = 1.0 - (oi.getRawAxis(3) + 1) / 2.0;
		if (isNotDeadzone(oi.getRawAxis(0)))
			Xaxis = oi.getRawAxis(0);
		else
			Xaxis = 0.0;
		if (isNotDeadzone(oi.getRawAxis(1)))
			Yaxis = oi.getRawAxis(1);
		else
			Yaxis = 0.0;
		if (isNotDeadzone(oi.getRawAxis(2)))
			Zaxis = oi.getRawAxis(2);
		else
			Zaxis = 0.0;
		//gyro-less drive is toggled on/off with button 7
		drive( oi.getRawAxis(0), oi.getRawAxis(1), oi.getRawAxis(2), multiplier, gyroDegDefault);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	public static boolean isNotDeadzone(double value) {
		if( Math.abs(value) > Robot.DEADZONE)
			return true;
		return false;
	}

	public static int checkSign(double checkNum) {
		if (checkNum < 0)
			return -1;
		if (checkNum > 0)
			return 1;
		return 0;
	}

	/**
	 * @deprecated used for hold button 7 for gyro-less
	 */
	public void drive(double x, double y, double rotation, double multiplier, boolean isGyro) {
		if( isGyro )
			myRobot.mecanumDrive_Cartesian(x * multiplier, y * multiplier, rotation * multiplier, gyro.getAngle());
		else
			myRobot.mecanumDrive_Cartesian(x * multiplier, y * multiplier, rotation * multiplier, 0);
	}
	
	public void drive(double x, double y, double rotation, double multiplier, double gyroDeg) {
//		if( isGyroCommand )
//			myRobot.mecanumDrive_Cartesian(x * multiplier, y * multiplier, rotation * multiplier, gyro.getAngle());
//		else
//			myRobot.mecanumDrive_Cartesian(x * multiplier, y * multiplier, rotation * multiplier, gyroDegrees);
		myRobot.mecanumDrive_Cartesian(x * multiplier, y * multiplier, rotation * multiplier, gyroDeg);

	}
}
