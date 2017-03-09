package org.usfirst.frc.team2554.robot.subsystems;

import org.opencv.core.Mat;
import org.usfirst.frc.team2554.robot.Robot;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class Camera extends Subsystem {
	UsbCamera gearCam = new UsbCamera("cam2",  0);
	UsbCamera pickUpCam = new UsbCamera("cam0", 1);
	CvSink shooterSink, pickUpSink;
	CvSource outputSource;
	boolean shooterBool = true;
	Mat image;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Camera(){
		super();
		setUpCamServer();
    	createSinks();
    	createSource();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setUpCamera(){
    	gearCam.setBrightness(0);
    	gearCam.setExposureManual(0);
    	pickUpCam.setBrightness(0);
    	pickUpCam.setExposureManual(0);
    }
    public void setUpCamServer(){
    	CameraServer.getInstance().addCamera(gearCam);
    	CameraServer.getInstance().addCamera(pickUpCam);
    }
    public void createSinks(){
    	shooterSink = CameraServer.getInstance().getVideo(gearCam);
    	pickUpSink = CameraServer.getInstance().getVideo(pickUpCam);
    	shooterSink.setEnabled(shooterBool);
    	pickUpSink.setEnabled(!shooterBool);
    }
    public void createSource(){
    	//Change resolution
    	CameraServer.getInstance().putVideo("Dashboard Viewer", 480, 640);
    }
    public void switchCam(){
    	shooterBool = !shooterBool;
    	shooterSink.setEnabled(shooterBool);
    	pickUpSink.setEnabled(!shooterBool);
    }
    public void grabImage(){
    	if(shooterBool)
    		shooterSink.grabFrame(image);
    	else
    		pickUpSink.grabFrame(image);
    		
    }
    public void outputVideo(){
    	grabImage();
    	outputSource.putFrame(image);
    }
    
}
