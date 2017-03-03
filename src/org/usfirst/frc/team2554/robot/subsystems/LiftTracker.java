package org.usfirst.frc.team2554.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;;
/**
 *
 */
public class LiftTracker extends Subsystem {
	private NetworkTable gripTable = NetworkTable.getTable("GRIP/myContoursReport");
	private double[] x, y, area, defaultArray = new double[0];
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void updateTable(){
    	x = gripTable.getNumberArray("centerX", defaultArray);
    	y = gripTable.getNumberArray("centerY", defaultArray);
    	area = gripTable.getNumberArray("area", defaultArray);
    }
    public double[] returnX(){
    	return x;
    }
    public double[] returnY(){
    	return y;
    }
    public double[] returnArea(){
    	return area;
    }
    public double returnWeightedX(){
    	double areaSum = 0, weightedX = 0;
    	for(double element: area)
    		areaSum += element;
    	for(int counter = 0; counter < x.length; counter++)
    		weightedX += x[counter] * area[counter] / areaSum;
    	return weightedX;
    }
    public double returnWeightedY(){
    	double areaSum = 0, weightedY = 0;
    	for(double element: area)
    		areaSum += element;
    	for(int counter = 0; counter < y.length; counter++)
    		weightedY += y[counter] * area[counter] / areaSum;
    	return weightedY;
    }
    public double returnAverageX(){
    	double averageX = 0;
    	for(double element: x)
    		averageX += element;
    	return averageX / x.length;
    }
    public double returnAverageY(){
    	double averageY = 0;
    	for(double element: y)
    		averageY += element;
    	return averageY / y.length;
    }
}
