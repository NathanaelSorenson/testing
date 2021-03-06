// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */

double LeftJoystick_Y;
double RightJoystick_X;
double RSpeed;
double LSpeed;
double FBmulti;
double LRmulti;


  public ArcadeDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drive_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {



  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //FBmulti = SmartDashboard.getNumber("FBmulti", 0);
    //LRmulti = SmartDashboard.getNumber("LRmulti", 0);
LeftJoystick_Y = RobotContainer.LeftJoystick.getY();
RightJoystick_X = RobotContainer.RightJoystick.getX();
SmartDashboard.putNumber("leftY", LeftJoystick_Y);
FBmulti = .3;
LRmulti = .1;

RSpeed = (LeftJoystick_Y * FBmulti) + (RightJoystick_X * LRmulti);
LSpeed = (LeftJoystick_Y * FBmulti) - (RightJoystick_X * LRmulti);


RobotContainer.drive_subsystem.setSpeed(RSpeed, LSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drive_subsystem.setSpeed(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
