package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class PreliminaryMotorTest extends Command{

	
    //Robot robot;
    int time;
    int direction;
    
	public PreliminaryMotorTest(int t, int d) {
    	//super("Drive");
        requires(Robot.driveTrainTalon); 
        //this.setInterruptible(false);
        time = t;
        direction = d;                
        
    }

    // 	initialize() - This method sets up the command and is called immediately before the command is executed for the first time and every subsequent time it is started .
    //  Any initialization code should be here. 
    protected void initialize() {
    	setTimeout(time);
    	Robot.driveTrainTalon.openL(direction);
    	Robot.driveTrainTalon.openR(direction);
    	
    }

   
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }
    
    protected void end() {
    	Robot.driveTrainTalon.stop();
    	Robot.drive.start();
    	
    }
    
    protected void interupt() {
    	end();
    	
    }

}
