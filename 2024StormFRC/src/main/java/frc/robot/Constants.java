package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

// Generated by the Tuner X Swerve Project Generator
// https://v6.docs.ctr-electronics.com/en/stable/docs/tuner/tuner-swerve/index.html
public class Constants {
        public static final double stickDeadband = 0.1;

    //Motor CAN IDs
    public static final int LeftClimb = 7;
    public static final int RightClimb = 2;
    public static final int LeftShooter = 5;
    public static final int RightShooter = 6;
    public static final int LeftArm = 3;
    public static final int RightArm = 10;
    public static final int Intake = 8;
    public static final int AbsoluteEncoder = 0;


    public static final double armPower = 0.6;
  
    //Sensor CAN IDs
    public static final int armEncoder = 0;

    //auto constants
    public static final double autoShootingVelocity = 2;

    //Arm Positions
    public static final double armFloorPosition = 0;
    public static final double armAmpPosition = 90;

    public static final class SwerveConstants {
        public static final double MaxSpeed = 6;
        public static final double MaxAngularSpeed = 4 * Math.PI;
    }

    public static final class PoseConstants {
        public static final Pose2d defaultPose = new Pose2d(new Translation2d(0,0), Rotation2d.fromDegrees(0));
        public static final Pose2d Blue1Pose = new Pose2d(new Translation2d(2,7), Rotation2d.fromDegrees(0));
        public static final Pose2d Blue2Pose = new Pose2d(new Translation2d(2,5), Rotation2d.fromDegrees(0));
        public static final Pose2d Blue3Pose = new Pose2d(new Translation2d(2,2), Rotation2d.fromDegrees(0));

    }




}