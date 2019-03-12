package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;


public class CargoMiddle extends Command{

	
    
    

    
	public CargoMiddle() {
    	//super("Drive");
        requires(Robot.cargo); 
        //this.setInterruptible(false);                 
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        
        //setTimeout(10);
        //Robot.cargo.setTalonMiddle(0.5);
    }

   
    protected void execute() {
        
        

        //Robot.cargo.setTalonIntake(Robot.robotMap.speedMiddle* Math.signum(Robot.oi.stick1.getThrottle()));
        Robot.cargo.setTalonMiddle(Robot.oi.stick2.getThrottle()*0.5);
        SmartDashboard.putNumber("Throttle: ", Robot.oi.stick2.getThrottle());
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    	
        Robot.cargo.setTalonMiddle(0);


    	
    }
    
    protected void interupt() {
    	end();
    	
    }

}
