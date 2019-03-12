package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Joystick;
import com.kauailabs.navx.frc.AHRS;

import java.lang.Math;

public class Autonomous extends CommandGroup{
	/*
	 * 1.	Constructor - Might have parameters for this command such as target positions of devices. Should also set the name of the command for debugging purposes.
	 *  This will be used if the status is viewed in the dashboard. And the command should require (reserve) any devices is might use.
	 *  delete this portion of the comment later
	 */
	
	//Robot robot;

	//Joystick stick1 = new Joystick(0);
	//Joystick stick2 = new Joystick(1);
	
	
    public Autonomous() {
    	//super("Drive");
        requires(Robot.driveTrainTalon);                  
        
    
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
    	SmartDashboard.putNumber("stage of completion", 1);
    	//setTimeout(5);
    	
    	
    }

    /*
     *	execute() - This method is called periodically (about every 20ms) and does the work of the command. Sometimes, if there is a position a
     *  subsystem is moving to, the command might set the target position for the subsystem in initialize() and have an empty execute() method.
     */
    protected void execute() {
		//SmartDashboard.putNumber("Y: ", stick1.getY());
		/*
    	if(Math.abs(stick1.getY()) > 0.1)
    	{
    		Robot.driveTrainTalon.setTalonL(stick1.getY()*(1+stick1.getZ())*0.25);
			Robot.driveTrainTalon.setTalonR(stick1.getY()*(1-stick1.getZ())*0.25);
			

        	
    	}
    	else if(Math.abs(stick1.getZ()) > 0.5)
    	{
    		Robot.driveTrainTalon.setTalonL(stick1.getZ()*0.5);
    		Robot.driveTrainTalon.setTalonR(stick1.getZ()*0.5);
    		
		}
		*/
		Robot.driveTrainTalon.wpilibDrive(-Robot.oi.stick1.getY(), Robot.oi.stick1.getZ(), true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	SmartDashboard.putNumber("stage of completion", 2);
    	Robot.driveTrainTalon.stop();
    	
    }
    
    protected void interupt() {
    	end();
    }
}
