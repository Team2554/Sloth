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
		public double getRawAxis( int axis ) {
			return controller.getRawAxis(axis);
		}
		public double getAbsRawAxis( int axis ) { return Math.abs( controller.getRawAxis(axis) ); }

	//Mapping of the Axis on the Joystick
		final public int stickLeftX = 0;
		final public int stickLeftY = 1;
		final public int stickRightX = 4;
		final public int stickRightY = 5;
	//Buttons
		//Button Locations
		final private int climb = 1;
		final private int drivePID = 2;

		//Button objects
		Button climbButton = new JoystickButton(controller, climb);
		Button drivePIDButton = new JoystickButton(controller, drivePID);
	//Triggers
		Trigger shootingTrigger = new JoystickAxis(controller, stickRightY);
		Trigger intakeTrigger = new JoystickAxis(controller, stickLeftY);

	/* I'M NOT DELETING THESE YET */

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
