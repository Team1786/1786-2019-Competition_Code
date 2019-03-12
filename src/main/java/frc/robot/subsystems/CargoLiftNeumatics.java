/**
 * 
 */
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;

/**
 * @author willwroble
 *
 */
public class CargoLiftNeumatics extends Subsystem{
		
	//Spark spark1 = new Spark(0);

	//WPI_TalonSRX talonLatch = new WPI_TalonSRX(10);
	Compressor compressor;
	Solenoid solenoid1;
	Solenoid solenoid2;

	public boolean cargoIsUp = false;


	public CargoLiftNeumatics() {

    }
	public void initDefaultCommand() {
		compressor = new Compressor(0);
        compressor.setClosedLoopControl(true);

		solenoid1 = new Solenoid(1); 
		solenoid2 = new Solenoid(2); 

		cargoIsUp = false;
        
		
	}
	public void setSolenoid(Boolean state) {

		solenoid1.set(state);
		solenoid2.set(state);
	}
	public void stop() {
		
		solenoid1.set(false);
		
	}

 	
}
