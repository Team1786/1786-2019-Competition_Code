package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

import java.lang.Math;

import com.kauailabs.navx.frc.AHRS;




public class TestIR extends Command{
	/*
	 * 1.	Constructor - Might have parameters for this command such as target positions of devices. Should also set the name of the command for debugging purposes.
	 *  This will be used if the status is viewed in the dashboard. And the command should require (reserve) any devices is might use.
	 *  delete this portion of the comment later
	 */
	

    //static final double kToleranceDegrees = 2.0f;
    
	
    public TestIR() {
    	//super("Drive");
        requires(Robot.driveTrainTalon);                  
        
       
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        
    
    }

    /*
     *	execute() - This method is called periodically (about every 20ms) and does the work of the command. Sometimes, if there is a position a
     *  subsystem is moving to, the command might set the target position for the subsystem in initialize() and have an empty execute() method.
     */
    protected void execute() {
		
        SmartDashboard.putBoolean("IR SENSOR: ", Robot.driveTrainTalon.getIR());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	
    	
    }

    protected void interupt() {
    	end();
    }
}
