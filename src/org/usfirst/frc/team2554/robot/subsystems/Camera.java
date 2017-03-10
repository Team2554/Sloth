package org.usfirst.frc.team2554.robot.subsystems;

import org.opencv.core.Mat;
import org.usfirst.frc.team2554.robot.RobotMap;


import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class Camera extends Subsystem {
	//public Camera(){}
	private UsbCamera gearCam;
	private UsbCamera climberCam ;
	private MjpegServer outputServer;
	private boolean isGearCam;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
  
    public Camera(){
    	gearCam  = new UsbCamera("cam2", 3);
    	climberCam= new UsbCamera("cam0", 2);
    	outputServer = new MjpegServer("serve_camera", 1181);
    	setUpCamera();
    	outputServer.setSource(gearCam);
    	isGearCam = true;
    }
    public void setUpCamera(){
    	gearCam.setResolution(640, 480);
    	climberCam.setResolution(640, 480);
    	gearCam.setBrightness(50);
    	gearCam.setExposureManual(0);
    	climberCam.setBrightness(50);
    	climberCam.setExposureManual(0);
    }
    public void switchCam(){
    isGearCam = !isGearCam;
    if(isGearCam)
    	outputServer.setSource(gearCam);
    else
    	outputServer.setSource(climberCam);
    }
    

//	protected void initDefaultCommand(){}
}
