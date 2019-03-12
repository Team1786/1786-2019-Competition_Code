package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;


public class Climb extends Command{

	
    
    

    
	public Climb() {
    	//super("Drive");
        requires(Robot.climber); 
        //this.setInterruptible(false);                 
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        
        
    	
    }

   
    protected void execute() {
       
        Robot.climber.setTalonClimb(-Robot.oi.stick2.getThrottle());
        SmartDashboard.putNumber("CLIMBER VALUE", Robot.oi.stick2.getThrottle());
    
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }
    
    protected void end() {
        
        Robot.climber.stop();

    }
    
    protected void interupt() {
    	end();
    	
    }

}
