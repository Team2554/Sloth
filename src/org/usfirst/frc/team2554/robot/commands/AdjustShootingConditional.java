package org.usfirst.frc.team2554.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

import org.usfirst.frc.team2554.robot.Robot;
public class AdjustShootingConditional extends ConditionalCommand{

	public AdjustShootingConditional(Command onTrue) {
		super(onTrue);
	}
	public boolean condition(){
		//The boolean may need a !. I don't remember my reasoning for having one right now.
		return Robot.feederSwitch.get();
	}
}
