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
public class HatchPusher extends Subsystem{
		
	//Spark spark1 = new Spark(0);

	//WPI_TalonSRX talonLatch = new WPI_TalonSRX(10);
	Compressor compressor;
    Solenoid solenoid;



	public HatchPusher() {

    }
	public void initDefaultCommand() {
		compressor = new Compressor(0);
        compressor.setClosedLoopControl(true);

        solenoid = new Solenoid(0);  
        
		
	}
	public void setSolenoid(Boolean state) {

		solenoid.set(state);
	}
	public void stop() {
		
		solenoid.set(false);
		
	}

 	
}
