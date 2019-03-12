package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Joystick;


public class CargoIntake extends Command{

	
    
    //public double speedL = .1;
    //public double speedR = .1;
    //Robot robot;

    //Joystick stick1 = new Joystick(0);

    boolean isRunning = false;

	public CargoIntake() {
    	//super("Drive");
        //requires(Robot.cargo); 
        //this.setInterruptible(false);                 
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
        //setTimeout(3);
        //SmartDashboard.putNumber("speed left: ", speedL);
        //SmartDashboard.putNumber("speed Right: ", speedR);

    	//Robot.driveTrainTalon.openL();
        //Robot.driveTrainTalon.openR();
        
        
    	
    }

   
    protected void execute() {
        
        /*
        if(isRunning){
            Robot.driveTrainTalon.setTalonR(stick1.getThrottle());

            if(stick1.getRawButtonReleased(7)){
                isRunning = false;
                Robot.driveTrainTalon.setTalonR(0);
                
            }
        }
        else if (stick1.getRawButtonReleased(7)){

            isRunning = true;
        }
        */
        
        //Robot.cargo.setTalonIntake(Robot.robotMap.speedIntake* Math.signum(Robot.oi.stick1.getThrottle()));
        Robot.cargo.setTalonIntake(Robot.oi.stick2.getThrottle()*0.5);
        SmartDashboard.putNumber("Throttle: ", Robot.oi.stick2.getThrottle());
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }
    protected void end() {
    	Robot.cargo.setTalonIntake(0);
    	//Robot.drive.start();
    	
    }
    
    protected void interupt() {
    	end();
    	
    }

}
