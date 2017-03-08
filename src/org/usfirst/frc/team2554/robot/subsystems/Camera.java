package org.usfirst.frc.team2554.robot.subsystems;

import org.opencv.core.Mat;
import org.usfirst.frc.team2554.robot.commands.SetUpCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class Camera extends Subsystem {
	private UsbCamera shooterCam = new UsbCamera("cam2", 3);
	private UsbCamera pickUpCam = new UsbCamera("cam0", 2);
	private CvSink shooterSink, pickUpSink;
	private CvSource outputSource;
	private boolean shooterBool = true;
	Mat image;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SetUpCamera());
    }
    /*
    public void Camera(){
    	setUpCamera();
    	setUpCamServer();
  //  	createSinks();
    //	createSource();
    }
    public void setUpCamera(){
    	shooterCam.setBrightness(0);
    	shooterCam.setExposureManual(0);
    	pickUpCam.setBrightness(0);
    	pickUpCam.setExposureManual(0);
    }
    public void setUpCamServer(){
    	CameraServer.getInstance().addCamera(shooterCam);
    	CameraServer.getInstance().addCamera(pickUpCam);
    }
    
    public void createSinks(){
    	pickUpSink = CameraServer.getInstance().getVideo(pickUpCam);
    	pickUpSink.setEnabled(false);
    	shooterSink = CameraServer.getInstance().getVideo(shooterCam);
    	shooterSink.setEnabled(false);
    	shooterSink.setEnabled(shooterBool);
    	pickUpSink.setEnabled(!shooterBool);
    }
    public void createSource(){
    	//Change resolution
    	CameraServer.getInstance().putVideo("Dashboard Viewer", 640, 480);
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
    }*/
    
}
