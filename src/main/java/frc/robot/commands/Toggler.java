package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.junit.rules.Timeout;

import edu.wpi.first.wpilibj.Joystick;


public class Toggler extends Command{

	
    
    //public double speedL = .1;
    //public double speedR = .1;
    String commandKey;

    

	public Toggler(String command) {
    	
        
        commandKey = command;
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        
        
        if(commandKey == "Intake")
        {
            if(Robot.cargoIntake.isRunning()) {
           
                SmartDashboard.putString("output33:", " you made a mistake making me");
                Robot.cargoIntake.cancel();
                Robot.cargoMiddle.cancel();
            }
            else {
                
                Robot.cargoIntake.start();
                Robot.cargoMiddle.start();
                SmartDashboard.putString("output21:", "KILL CHEN KILL CHEN KILL CHEN KILL CHEN");
    
    
            }
        }
        else if(commandKey == "Middle")
        {
            if(Robot.cargoMiddle.isRunning()) {
           
                SmartDashboard.putString("output36:", "What are your orders commander harass in");
                Robot.cargoMiddle.cancel();
            }
            else {
                
                Robot.cargoMiddle.start();
                SmartDashboard.putString("output87:", "Chen target aquired");
    
    
            }
        }
        else if(commandKey == "Deliver")
        {
            if(Robot.cargoDeliver.isRunning()) {
           
                SmartDashboard.putString("output112:", "I hope the humans don't see this");
                Robot.cargoDeliver.cancel();
            }
            else {
                
                Robot.cargoDeliver.start();
                SmartDashboard.putString("output321:", "What am I");
    
    
            }
        }
        else if(commandKey == "Lift")
        {
            if(Robot.cargoLiftNeumatics.cargoIsUp) {
           
                Robot.cargoDrop.start();
                SmartDashboard.putString("output123:", "kirbysuck");



            }
            else {
                
                Robot.cargoLift.start();
                SmartDashboard.putString("output577:", "yoshisuck");
    
    
            }

        }
        else if(commandKey == "LiftIntake")
        {
            if(Robot.cargo.cargoIntakeIsUp) {
           
                Robot.cargoIntakeDrop.start();
                SmartDashboard.putString("output123:", "I reprt only to general Silento");



            }
            else {
                
                Robot.cargoIntakeLift.start();
                SmartDashboard.putString("output577:", "uwu");
    
    
            }
        }
        end();
    }
    protected void execute() {
     
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //SmartDashboard.putBoolean("is this happening jan 28: ", isRunning);
        //isRunning = true;
        return true;
    }
    
}
