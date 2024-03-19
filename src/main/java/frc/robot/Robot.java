// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.Manipulator;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.Telescope;

import java.util.HashMap;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private Manipulator manip;
  private Telescope arm;
  private double currArmTarget;

  private XboxController xbox;

  private Pigeon2 gyro = new Pigeon2(0);
  private final HashMap<String, Pose2d> poseMap = new HashMap<>();
  private final Swerve drivetrain = TunerConstants.DriveTrain;
  private Pose2d initialPose;




  // @Override
  // public void robotInit() {

  //   m_robotContainer = new RobotContainer();
  //   // Initialize subsystems
  //   manip = new Manipulator();
  //   arm = new TelescopingArm();
  //   currArmTarget = 0;

    
  //   xbox = new XboxController(1);
  //   gyro.setYaw(-gyro.getYaw().getValue());
  // }

  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    manip = new Manipulator();
    arm = new Telescope();
    currArmTarget = 0;


    m_robotContainer = new RobotContainer();

    poseMap.put("Unknown", Constants.PoseConstants.defaultPose);
    poseMap.put("Blue1", Constants.PoseConstants.Blue1Pose);
    poseMap.put("Blue2", Constants.PoseConstants.Blue2Pose);
    poseMap.put("Blue3", Constants.PoseConstants.Blue3Pose);

  }


  

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    initialPose = poseMap.get(DriverStation.getRawAllianceStation().toString());
    drivetrain.seedFieldRelative(initialPose);

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {

    SmartDashboard.putNumber("Arm Target", currArmTarget);
    SmartDashboard.putNumber("Arm", manip.get_arm_enc());
    SmartDashboard.putNumber("Yaw", gyro.getYaw().getValue());
  
  }
  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

  @Override
  public void simulationPeriodic() {}
}




    


