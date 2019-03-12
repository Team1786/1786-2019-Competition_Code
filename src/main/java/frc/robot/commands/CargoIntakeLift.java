package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;


public class CargoIntakeLift extends Command{

	
    
    

    
	public CargoIntakeLift() {
    	//super("Drive");
        requires(Robot.cargo); 
        //this.setInterruptible(false);                 
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        
        setTimeout(1);
        Robot.cargo.setSparkLift(0.3);
        
    	
    }

   
    protected void execute() {
        
    
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }
    
    protected void end() {
        
        Robot.cargo.cargoIntakeIsUp = true;
        Robot.cargo.setSparkLift(0.05);

    }
    
    protected void interupt() {
    	end();
    	
    }

}
