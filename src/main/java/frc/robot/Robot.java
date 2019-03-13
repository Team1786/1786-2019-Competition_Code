/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*-----------------------*/
/* Team 1786             */
/* 2019 Competition Code */
/*-----------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.Trigger.ButtonScheduler;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import java.lang.Math;
//import frc.robot.RobotMap;


import frc.robot.commands.Drive;
//import frc.robot.commands.PreliminaryMotorTest;
import frc.robot.commands.HatchPush;
import frc.robot.commands.CargoIntake;
import frc.robot.commands.CargoMiddle;
import frc.robot.commands.CargoDeliver;
import frc.robot.commands.TestIR;
import frc.robot.commands.Climb;

import frc.robot.commands.CargoLift;
import frc.robot.commands.CargoDrop;
import frc.robot.commands.CargoIntakeLift;
import frc.robot.commands.CargoIntakeDrop;


//auto
import frc.robot.commands.AutoRotatePID;
import frc.robot.commands.AutoMovePID;



import frc.robot.subsystems.DriveTrainTalon;
import frc.robot.subsystems.Cargo;
import frc.robot.subsystems.HatchPusher;
import frc.robot.subsystems.CargoLiftNeumatics;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Camera;


//import frc.robot.commands.Toggler;

//import frc.robot.OI;


//import edu.wpi.first.wpilibj.PWMTalonSRX;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the packa ge after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static Command drive;
	//public static Command motorTest;
	public static Command hatchPush;
	public static Command cargoIntake;
	public static Command cargoMiddle;
	public static Command cargoDeliver;
	public static Command cargoLift;
	public static Command cargoDrop;
	public static Command cargoIntakeLift;
	public static Command cargoIntakeDrop;
	public static Command climb;


	public static Command autoRotatePID;
	public static Command autoMovePID;

	public static Command testIR;


	
	//SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	//public static DriveTrain driveTrain;
	public static DriveTrainTalon driveTrainTalon;
  	public static Cargo cargo;
	public static HatchPusher hatchPusher;
	public static CargoLiftNeumatics cargoLiftNeumatics;
	public static Climber climber;

	public static OI oi;
	public static RobotMap robotMap;
	public static Camera camera;

	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		
		
		//driveTrain = new DriveTrain();
		driveTrainTalon = new DriveTrainTalon();
    	cargo = new Cargo();
		hatchPusher = new HatchPusher();
		cargoLiftNeumatics = new CargoLiftNeumatics();
		climber = new Climber();
		camera = new Camera();
		
		drive = new Drive();
		//motorTest = new PreliminaryMotorTest();
		hatchPush = new HatchPush();
		cargoIntake = new CargoIntake();
		cargoMiddle = new CargoMiddle();
		cargoDeliver = new CargoDeliver();
		cargoLift = new CargoLift();
		cargoDrop = new CargoDrop();
		cargoIntakeLift = new CargoIntakeLift();
		cargoIntakeDrop = new CargoIntakeDrop();
		climb = new Climb();

		autoRotatePID = new AutoRotatePID();
		autoMovePID = new AutoMovePID();
		testIR = new TestIR();


		oi = new OI();
		
		
		//m_chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", m_chooser);

		//Scheduler.getInstance().add(armMove);
		//scheduler.add(armMove);
		//buttonScheduler.equals(oi.buttonArm);
		//scheduler.addButton(oi.buttonArm);
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		//m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		/*
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
		*/
		//cargo.setTalonMiddle(0.3);
		//motorTest.start();
		drive.start();
		
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		/*
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		*/
		
		//cargo.setTalonMiddle(0);
		//SmartDashboard.putBoolean("commandEnded", false);
		//motorTest.start();
		drive.start();
		//cargoMiddle.start();
		//cargo.setTalonMiddle(0.5);
		//cargoIntake.start();
		//cargoIn.start();
		//armMove.start();
		//autoRotate.start();
		//autoRotatePID.start();
		//testIR.start();
		//autoMovePID.start();
		//cargoMiddle.start();
		

		//SmartDashboard.putBoolean("commandEnded", true);
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//System.out.println(cargo.getCurrentCommandName());

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
    //hello
	}
}
