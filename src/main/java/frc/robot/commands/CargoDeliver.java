package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;


public class CargoDeliver extends Command{

	
    
    //public double speedL = .1;
    //public double speedR = .1;
    //Robot robot;

    

    
	public CargoDeliver() {
    	//super("Drive");
        requires(Robot.cargo); 
        //this.setInterruptible(false);                 
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        
    	
    }

   
    protected void execute() {
        
        
        //Robot.cargo.setTalonIntake(Robot.robotMap.speedDeliver* Math.signum(Robot.oi.stick1.getThrottle()));
        Robot.cargo.setTalonDeliver(Robot.oi.stick2.getThrottle()*0.75);
        SmartDashboard.putNumber("Throttle: ", Robot.oi.stick2.getThrottle());
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }
    protected void end() {
        
        Robot.cargo.setTalonDeliver(0);
    	
    }
    
    protected void interupt() {
    	end();
    	
    }

}
