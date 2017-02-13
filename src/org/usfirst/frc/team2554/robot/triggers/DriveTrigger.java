package org.usfirst.frc.team2554.robot.triggers;

import org.usfirst.frc.team2554.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class DriveTrigger extends Trigger{
	Joystick controller;
	public DriveTrigger(Joystick controller){
		this.controller = controller;
	}
	@Override
	public boolean get() {
		return (Robot.isNotDeadzone(controller.getRawAxis(0)) && Robot.isNotDeadzone(controller.getRawAxis(4))) || (Robot.isNotDeadzone(controller.getRawAxis(1)) && Robot.isNotDeadzone(controller.getRawAxis(5)));
	}
}
