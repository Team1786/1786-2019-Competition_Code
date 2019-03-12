/**
 * 
 */
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Spark;

//import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 * @author willwroble
 *
 */
public class Climber extends Subsystem{
		
	//Spark spark1 = new Spark(0);	

	WPI_TalonSRX talonClimb = new WPI_TalonSRX(10);
	


	public Climber() {
		

	}
	public void initDefaultCommand() {
		
	}
    public void setTalonClimb(double y)
    {
        talonClimb.set(y);
    }
	public void stop() {
		
		talonClimb.set(0);
		
		
	}

 	
}
