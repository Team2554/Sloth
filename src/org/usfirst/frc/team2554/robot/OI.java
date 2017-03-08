package org.usfirst.frc.team2554.robot;

import org.usfirst.frc.team2554.robot.triggers.JoystickAxis;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//Controller Ports
		public Joystick controller = new Joystick(0);
		public Joystick joystick = new Joystick(1);
		public double getRawAxis( int axis ) {
			return joystick.getRawAxis(axis);
		}
	//Face Buttons
		final private int aButton = 1;
		final public static int bButton = 2;
		final public int yButton = 4;
	//Bumpers and Triggers
		final public int rBumper = 6;
		final public int lBumper = 5;
		final public int rTrigger = 3;
		final public int lTrigger = 2;
	//Joystick
		//Buttons
			//Check number and if is button
		final public int triggerButton = 1;
		final public int sideButton7 = 7;
		final public int sideButton11 = 11;
		//Axes
		final public int stickLeftX = 0;
		final public int stickLeftY = 1;
		final public int stickRightX = 4;
		final public int stickRightY = 5;
	//Buttons
		Button climbButton = new JoystickButton(controller, aButton);
		Button intakeButton = new JoystickButton(controller, rBumper);
		Button switchCamButton = new JoystickButton(joystick, triggerButton);
		Button feederBackButton = new JoystickButton(controller, lBumper);
		Button turnCamButton = new JoystickButton(controller, yButton);
		Button resetGyroButton = new JoystickButton(joystick, sideButton11);
	//Triggers
		Trigger shootingTrigger = new JoystickAxis(controller, rTrigger);
		Trigger feederTrigger = new JoystickAxis(controller, lTrigger);
}
