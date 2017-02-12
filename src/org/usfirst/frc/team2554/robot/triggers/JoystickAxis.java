package org.usfirst.frc.team2554.robot.triggers;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class JoystickAxis extends Trigger {
	Joystick joystick;
	int axis;
	public JoystickAxis(Joystick joystk, int axs){
		joystick = joystk;
		axis = axs;
	}
    public boolean get() {
        return joystick.getRawAxis(axis) != 0;
    }
}
