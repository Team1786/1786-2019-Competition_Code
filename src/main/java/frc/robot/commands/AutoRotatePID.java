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


public class AutoRotatePID extends Command implements PIDOutput{
	/*
	 * 1.	Constructor - Might have parameters for this command such as target positions of devices. Should also set the name of the command for debugging purposes.
	 *  This will be used if the status is viewed in the dashboard. And the command should require (reserve) any devices is might use.
	 *  delete this portion of the comment later
	 */
	
	//Robot robot;

	//Joystick stick1 = new Joystick(0);
    //Joystick stick2 = new Joystick(1);
    

    
    AHRS ahrs;
    PIDController turnController;
    double rotateToAngleRate;
    

    static final double kP = 0.03;
    static final double kI = 0.00;
    static final double kD = 0.00;
    static final double kF = 0.00;

    static final double kToleranceDegrees = 2.0;

    int rotateFinal;

    boolean weAreThere;
    
    //static final double kToleranceDegrees = 2.0f;
	
    public AutoRotatePID() {
    	//super("Drive");
        requires(Robot.driveTrainTalon);                  
        ahrs = new AHRS(SPI.Port.kMXP);


    
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        
        
        rotateFinal = -90;

        weAreThere = false;
       
        turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
        turnController.setInputRange(-180.0f,  180.0f);
        turnController.setOutputRange(-1.0, 1.0);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);
        turnController.setEnabled(true);
        

        turnController.setSetpoint(rotateFinal);

        ahrs.reset();
        
        
        
        //rotateToAngleRate = 1;

    	
    }

    /*
     *	execute() - This method is called periodically (about every 20ms) and does the work of the command. Sometimes, if there is a position a
     *  subsystem is moving to, the command might set the target position for the subsystem in initialize() and have an empty execute() method.
     */
    protected void execute() {
		//SmartDashboard.putNumber("Y: ", stick1.getY());
        //ahrs.
        
        SmartDashboard.putNumber("navx Data: ", ahrs.getAngle());
        SmartDashboard.putNumber("Rotate Rate: ", rotateToAngleRate);

        
        

        /*
        if(rotateToAngleRate == -1)
        {
            turnController.setEnabled(false);
            
            end();
            

        }
        */
        Robot.driveTrainTalon.wpilibRotate(rotateToAngleRate);


        /*
        if(rotateToAngleRate == -Math.signum(rotateFinal) && !weAreThere)
        {
            setTimeout(2);
            weAreThere = true;
            SmartDashboard.putBoolean("what is going on!", true);
        }
        */
        
        
        Timer.delay(0.005);

        
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

        
        
        if(rotateToAngleRate == -Math.signum(rotateFinal) && !weAreThere)
        {
            setTimeout(3.5);
            weAreThere = true;
        }
        
        
        if(weAreThere && isTimedOut())
        {
            SmartDashboard.putBoolean("isThisTriggeringEarly: ", true);
            return true;
        }
        else
        {
            return false;
        }
        
        /*
        if(Math.abs(ahrs.getAngle()+rotateFinal)<2)
        {
            return true;
        }
        else
        {
            return false;
        }
        */
        //return false;
        
        
        
        
    }
    
    protected void end() {
    	SmartDashboard.putString("we stopped", "");
        Robot.driveTrainTalon.stop();
        ahrs.reset();
        
    	
    }

    
    
    protected void interupt() {
    	end();
    }
    
    public void pidWrite(double output) {
        rotateToAngleRate = output;

    }
}
