package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.junit.rules.Timeout;

import edu.wpi.first.wpilibj.Joystick;





public class HatchPush extends Command{

	
    
    //public double speedL = .1;
    //public double speedR = .1;

    //Robot robot;

    Joystick stick1 = new Joystick(0);

    
    
	public HatchPush() {
    	
        //requires(Robot.hatchPusher);            
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        setTimeout(0.2);
        //SmartDashboard.putNumber("speed left: ", speedL);
        //SmartDashboard.putNumber("speed Right: ", speedR);

        //UN COMMENT THIS FOR LATER
        Robot.hatchPusher.setSolenoid(true);
        
        
        SmartDashboard.putString("output2:", "commander harass in is my enemy");
    	
    }

   
    protected void execute() {
        
        //SmartDashboard.putNumber("Y value from OI", Robot.oi.x);
       
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //SmartDashboard.putBoolean("is this happening jan 28: ", isRunning);
        //isRunning = true;
        return isTimedOut();
    }
    protected void end() {
        
        //UN COMMENT THIS FOR LATER
        Robot.hatchPusher.setSolenoid(false);


    }
    protected void interupt() {
        end();
    	
    }

}
