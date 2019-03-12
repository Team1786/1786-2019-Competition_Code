package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.junit.rules.Timeout;

import edu.wpi.first.wpilibj.Joystick;




public class CargoLift extends Command{

	
    
    //public double speedL = .1;
    //public double speedR = .1;

    //Robot robot;

    

    
    
	public CargoLift() {
    	//super("Drive");
        requires(Robot.cargoLiftNeumatics); 
        //this.setInterruptible(false);                 
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        

        
        Robot.cargoLiftNeumatics.setSolenoid(true);
        SmartDashboard.putString("Output:", "WE SHOULD BE LIFTING");
        Robot.cargoLiftNeumatics.cargoIsUp = true;
        this.cancel();
        
    	
    }

   
    protected void execute() {
        
        //SmartDashboard.putNumber("Y value from OI", Robot.oi.x);
       
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //SmartDashboard.putBoolean("is this happening jan 28: ", isRunning);
        //isRunning = true;
        return false;
    }
    protected void end() {
        
        //Robot.cargoLiftNeumatics.cargoIsUp = true;
        //Robot.cargoLiftNeumatics.setSolenoid(true);


    }
    protected void interupt() {
        end();
    	
    }

}
