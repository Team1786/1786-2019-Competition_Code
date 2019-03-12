/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.commands.HatchPush;
import frc.robot.commands.PreliminaryMotorTest;


import frc.robot.commands.Toggler;





/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  
  public Joystick stick1 = new Joystick(0);
  public Joystick stick2 = new Joystick(1);


  Button buttonHatchPusher = new JoystickButton(stick2, 7);//7

  Button buttonCargoIntake = new JoystickButton(stick2, 8); //8
  Button buttonCargoMiddle = new JoystickButton(stick2, 10); //10
  Button buttonCargoDeliver = new JoystickButton(stick2, 12); //12

  Button buttonCargoLift = new JoystickButton(stick2, 11);//11
  Button buttonCargoIntakeLift = new JoystickButton(stick2, 9);//9

  Button buttonClimber = new JoystickButton(stick2, 1);//1

  //Oliver's controlls

  Button buttonMoveForwardLong = new JoystickButton(stick1, 7);
  Button buttonMoveForwardShort = new JoystickButton(stick1, 8);
  Button buttonMoveBackwardLong = new JoystickButton(stick1, 9);
  Button buttonMoveBackwardShort = new JoystickButton(stick1, 10);



  
  
  

  public OI() {

    //SmartDashboard.putNumber("ARE WE EVEN GETTING HERE (OI): ", 999);
    buttonHatchPusher.whenReleased(Robot.hatchPush);
    
    buttonCargoIntake.whenReleased(new Toggler("Intake"));
    buttonCargoMiddle.whenReleased(new Toggler("Middle"));
    buttonCargoDeliver.whenReleased(new Toggler("Deliver"));

    buttonCargoLift.whenReleased(new Toggler("Lift"));
    buttonCargoIntakeLift.whenReleased(new Toggler("LiftIntake"));

    buttonClimber.whileHeld(Robot.climb);



    buttonMoveForwardLong.whenReleased(new PreliminaryMotorTest(2, 1));
    buttonMoveForwardShort.whenReleased(new PreliminaryMotorTest(1, 1));
    buttonMoveBackwardLong.whenReleased(new PreliminaryMotorTest(2, -1));
    buttonMoveBackwardShort.whenReleased(new PreliminaryMotorTest(1, -1));


    //Scheduler.getInstance().addButton(button);

  }
  
  

}
