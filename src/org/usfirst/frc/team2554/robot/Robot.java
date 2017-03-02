
package org.usfirst.frc.team2554.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;

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
	public static final double MULTIPLIER = 0.5;
	public static OI oi;
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static Feeder feeder = new Feeder();
	public static Shooter shooter = new Shooter();
	public static Intake intake = new Intake();
	public static Climber climber = new Climber();
	public static DigitalInput feederSwitch = new DigitalInput(RobotMap.limitSwitchFeeder);
	public static DigitalOutput lights = new DigitalOutput(RobotMap.lights);
	public static Encoder shooterEncoder = new Encoder(RobotMap.shooterEncoderA, RobotMap.shooterEncoderB);
	Command autonomousCommand;
	public static double Xaxis, Yaxis, Zaxis;
	// Should not be re-instantiated every time because a thread is created
	PIDController encoderController;
	Encoder encoder;
	Victor output;
	RobotDrive myRobot;

	public static ConditionalCommand adjustShooterConditional;
	SendableChooser<Command> chooser = new SendableChooser<>();
	public static Timer timer = new Timer();
	CameraServer cs;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		myRobot = new RobotDrive(RobotMap.driveTrain[0], RobotMap.driveTrain[1], RobotMap.driveTrain[2],
				RobotMap.driveTrain[3]);
		oi = new OI();
		oi.climbButton.whileHeld(new ClimbUp());
		oi.shootingTrigger.whileActive(new SpinShooter());
		oi.feederTrigger.whileActive(new SpinFeederForward());
		oi.intakeButton.whileHeld(new SpinIntake());
		oi.feederBackButton.whileHeld(new SpinFeederBackward());
		// oi.driveTrigger.whileActive(new MecaDrive());

		// Tune Numbers
		adjustShooterConditional = new AdjustShootingConditional(new AdjustShootingGroup());
		// output = new Victor(0);
		// encoderController = new PIDController(0,0,0,shooterEncoder, output);
		// encoderController.setPercentTolerance(15);
		// encoderController.setContinuous(false);
		// encoderController.setOutputRange(-1, 1);
		// LiveWindow.addActuator("Test", "PID", encoderController);
		// LiveWindow.addSensor("hi", "hi", shooterEncoder);
		LiveWindow.addSensor("hi", "hi", gyro);
		// chooser.addDefault("Default Auto", new DriveTrainDefault());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		// CHANGE Distance Value
		shooterEncoder.setDistancePerPulse(1);
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
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * 
	 * 
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		// myRobot.mecanumDrive_Cartesian(0, 0, 0.5, 0);
		Scheduler.getInstance().run();
		if (Math.abs(oi.getRawAxis(0)) > DEADZONE) {
			Xaxis = oi.getRawAxis(0);
		} else
			Xaxis = 0.0;
		if (Math.abs(oi.getRawAxis(1)) > DEADZONE) {
			Yaxis = oi.getRawAxis(1);
		} else
			Yaxis = 0.0;
		if (Math.abs(oi.getRawAxis(2)) > DEADZONE) {
			Zaxis = oi.getRawAxis(2);
		} else
			Zaxis = 0.0;
		
		if( oi.controller.getRawButton(4) ) {
//			lights.enablePWM(1);
//			lights.disablePWM();
//			lights.set(true);
			lights.pulse(1);
			System.out.println( "thanks for nothing dan");
		}

		drive(oi.getRawAxis(0) * MULTIPLIER, oi.getRawAxis(1) * MULTIPLIER, oi.getRawAxis(2) * MULTIPLIER);

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	public static boolean isNotDeadzone(double value) {
		if (value > Robot.DEADZONE || value < -Robot.DEADZONE)
			return true;
		return false;
	}

	public int checkSign(double checkNum) {
		if (checkNum < 0)
			return -1;
		if (checkNum > 0)
			return 1;
		return 0;
	}

	public void drive(double x, double y, double rotation) {
		myRobot.mecanumDrive_Cartesian(x, y, rotation, 0.0);
	}
}
