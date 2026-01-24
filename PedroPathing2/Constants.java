package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.ThreeWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {

    // ================================
    // 🚨 THREE WHEEL LOCALIZER CONSTANTS
    // ================================
    public static ThreeWheelConstants localizerConstants = new ThreeWheelConstants()
            // Your tick → inch multiplier
            .forwardTicksToInches(0.00294911544742713984)
            .strafeTicksToInches(0.002963768407857667)
            .turnTicksToInches(0.0029726)

            // Pod geometry
            .leftPodY(5.0)      // left parallel pod (+5 in)
            .rightPodY(-5.0)    // right parallel pod (–5 in)
            .strafePodX(-2.0)   // perp pod is 2 inches BEHIND center

            // Hardware names for encoders (using motors as encoders)
            .leftEncoder_HardwareMapName("outtake")   // left odometry pod
            .rightEncoder_HardwareMapName("intake")   // right odometry pod
            .strafeEncoder_HardwareMapName("ramp")    // perpendicular pod

            // Encoder directions, based on your testing
            .leftEncoderDirection(Encoder.REVERSE)    // outtake → REVERSE
            .rightEncoderDirection(Encoder.FORWARD)   // intake → FORWARD
            .strafeEncoderDirection(Encoder.FORWARD); // ramp → REVERSE


    // ================================
    // 🚨 FOLLOWER CONSTANTS
    // ================================
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(12.065)

            ;







    // ================================
    // 🚨 MECANUM DRIVE CONSTANTS
    // ================================
    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1.0)

            .rightFrontMotorName("rightFront")
            .rightRearMotorName("rightBack")
            .leftRearMotorName("leftBack")
            .leftFrontMotorName("leftFront")

            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD)
            .xVelocity(60.72675908492565)
            .yVelocity(52.221699835819);



    // ================================
    // 🚨 PATHING SPEED CONSTRAINTS
    // ================================
    public static PathConstraints pathConstraints =
            new PathConstraints(
                    0.9999,
                    260,
                    4,
                    4
            );


    // ================================
    // 🚨 CREATE FOLLOWER
    // ================================
    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .threeWheelLocalizer(localizerConstants)   // <— THIS IS CORRECT API
                .mecanumDrivetrain(driveConstants)
                .pathConstraints(pathConstraints)
                .build();
    }
}
