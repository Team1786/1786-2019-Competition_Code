/**
 * 
 */
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Spark;

//import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.can.*;


import edu.wpi.first.wpilibj.CameraServer;

/**
 * @author willwroble
 *
 */
public class Camera extends Subsystem{
		
	//Spark spark1 = new Spark(0);	

	



	public Camera() {
		

	}
	public void initDefaultCommand() {
        CameraServer.getInstance().startAutomaticCapture();
        
	}
	

 	
}
