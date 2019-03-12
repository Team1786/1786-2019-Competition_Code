/**
 * 
 */
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Spark;

//import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.can.*;







/**
 * @author willwroble
 *
 */
public class DriveTrainTalon extends Subsystem{
	
	//Spark spark1 = new Spark(0);	
	
	WPI_TalonSRX talonL1 = new WPI_TalonSRX(1);
	WPI_TalonSRX talonL2 = new WPI_TalonSRX(2);
	WPI_TalonSRX talonL3 = new WPI_TalonSRX(3);


	WPI_TalonSRX talonR1 = new WPI_TalonSRX(4);
	WPI_TalonSRX talonR2 = new WPI_TalonSRX(5);
	WPI_TalonSRX talonR3 = new WPI_TalonSRX(6);
	


	public DifferentialDrive myDrive;

	
	DigitalInput irOne = new DigitalInput(0);
	//get returns true or false



	public DriveTrainTalon() {
		
		myDrive = new DifferentialDrive(talonL1, talonR1);
		myDrive.setSafetyEnabled(false);

	}
	public void initDefaultCommand() {
		
		/*
		talonL1.configFactoryDefault();
		talonL2.configFactoryDefault();
		talonR1.configFactoryDefault();
		talonR2.configFactoryDefault();
		*/
		
		talonL2.follow(talonL1);
		talonL3.follow(talonL1);
		
		talonR2.follow(talonR1);
		talonR3.follow(talonR1);

		
	}
	public void setTalonL(double y) {
		talonL1.set(y);
	}
	public void setTalonR(double y) {
		talonR1.set(y);
	}
	public void wpilibDrive(double x, double z, boolean isSquared)
	{
		myDrive.arcadeDrive(x, z, isSquared);
	}
	public void wpilibRotate(double rotation) {
		myDrive.arcadeDrive(0, rotation*0.6);

	}
	public void openL(int d) {
		talonL1.set(0.5*d);
		//SmartDashboard.putNumber("are we on the talon L", 99);
	}
	public void openR(int d) {
		talonR1.set(-0.5*d);
		//SmartDashboard.putNumber("are we on the talon R", 99);
	}
	public boolean getIR() {

		return irOne.get();

	}
	public void close() {
		talonL1.set(-1);
	}
	public void stop() {
	//SmartDashboard.putNumber("stage of completion", 4);
		SmartDashboard.putNumber("are we on the talon L", 0);
		SmartDashboard.putNumber("are we on the talon R", 0);
		talonL1.set(0);
		talonR1.set(0);
		
	}

 	
 	
}
