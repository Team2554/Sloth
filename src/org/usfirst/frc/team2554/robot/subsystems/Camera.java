package org.usfirst.frc.team2554.robot.subsystems;

import org.opencv.core.Mat;
import org.usfirst.frc.team2554.robot.RobotMap;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class Camera extends Subsystem {
	public Camera(){}
	/*private UsbCamera shooterCam;
	private UsbCamera pickUpCam ;
	private CvSink shooterSink, pickUpSink;
	private boolean shooterBool;
	Mat image;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
  
    public Camera(){
    	shooterCam   = new UsbCamera("cam2", 3);
    	pickUpCam= new UsbCamera("cam0", 2);
    	setUpCamera();
    	shooterBool = true;
    	setUpCamServer();
    	createSinks();
    	createSource();
    }
    public void setUpCamera(){
    	shooterCam.setResolution(640, 480);
    	pickUpCam.setResolution(640, 480);
    	shooterCam.setBrightness(0);
    	shooterCam.setExposureManual(0);
    	pickUpCam.setBrightness(0);
    	pickUpCam.setExposureManual(0);
    	image = new Mat();
    }
    public void setUpCamServer(){
    	pickUpSink = CameraServer.getInstance().getVideo(pickUpCam);
    	pickUpSink.setEnabled(false);
    	shooterSink = CameraServer.getInstance().getVideo(shooterCam);
    	shooterSink.setEnabled(false);
    }
    
    public void createSinks(){
    	shooterSink.setEnabled(shooterBool);
    	pickUpSink.setEnabled(!shooterBool);
    }
    public void createSource(){
    	//Change resolution
//    	CameraServer.getInstance().putVideo("DanxKelly", 640, 480);
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
    	RobotMap.danxKelly.putFrame(image);
    }
    

*/	protected void initDefaultCommand(){}
}
