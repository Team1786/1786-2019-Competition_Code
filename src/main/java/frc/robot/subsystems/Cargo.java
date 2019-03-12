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
public class Cargo extends Subsystem{
		
	//Spark spark1 = new Spark(0);	

	WPI_TalonSRX talonIntake = new WPI_TalonSRX(7);
	WPI_TalonSRX talonMiddle = new WPI_TalonSRX(8);
	WPI_TalonSRX talonDeliver = new WPI_TalonSRX(9);

	Spark sparkLift = new Spark(0);

	public boolean cargoIntakeIsUp = false;





	public Cargo() {
		

	}
	public void initDefaultCommand() {
		
	}
	public void setTalonIntake(double y) {
		talonIntake.set(y);
		SmartDashboard.putNumber("Arm data base: ", y);
	}
	public void setTalonMiddle(double y) {
		talonMiddle.set(y);
	}
	public void setTalonDeliver(double y) {
		talonDeliver.set(y);
	}
	public void setSparkLift(double y)
	{
		sparkLift.set(y);
	}
	public void stop() {
		
		talonIntake.set(0);
		talonMiddle.set(0);
		talonDeliver.set(0);
		
	}

 	
}
