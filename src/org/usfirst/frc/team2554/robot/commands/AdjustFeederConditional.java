package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

import org.usfirst.frc.team2554.robot.Robot;
public class AdjustFeederConditional extends ConditionalCommand{

	public AdjustFeederConditional(Command onTrue) {
		super(onTrue);
	}
	public boolean condition(){
		return !Robot.feederSwitch.get();
	}
}
