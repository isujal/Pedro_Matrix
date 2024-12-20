package org.firstinspires.ftc.teamcode.pedroPathing.examples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedroPathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pedroPathing.localization.Pose;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.BezierCurve;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.BezierLine;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Path;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathBuilder;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.PathChain;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Point;
import org.firstinspires.ftc.teamcode.pedroPathing.util.Timer;

@Autonomous
public class PathTest extends LinearOpMode {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;

    /** This is the variable where we store the state of our auto.
     * It is used by the pathUpdate method. */
    private int pathState;
    private final Pose startPose = new Pose(9, 111, Math.toRadians(270));






    @Override
    public void runOpMode() throws InterruptedException {


        pathTimer = new Timer();
        opmodeTimer = new Timer();

        opmodeTimer.resetTimer();

        follower = new Follower(hardwareMap);
        follower.setStartingPose(startPose);

        PathBuilder builder = new PathBuilder();

        builder
                .addPath(
                        // Line 1
                        new BezierLine(
                                new Point(9, 59.182, Point.CARTESIAN),
                                new Point(40.092, 67.636, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 2
                        new BezierCurve(
                                new Point(40.092, 67.636, Point.CARTESIAN),
                                new Point(25.910, 72.545, Point.CARTESIAN),
                                new Point(18.001, 11.182, Point.CARTESIAN),
                                new Point(57.001, 48.545, Point.CARTESIAN),
                                new Point(59.729, 25.091, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 3
                        new BezierLine(
                                new Point(59.729, 25.091, Point.CARTESIAN),
                                new Point(19.092, 24.273, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 4
                        new BezierCurve(
                                new Point(19.092, 24.273, Point.CARTESIAN),
                                new Point(55.638, 37.091, Point.CARTESIAN),
                                new Point(60.819, 16.364, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 5
                        new BezierLine(
                                new Point(60.819, 16.364, Point.CARTESIAN),
                                new Point(19.365, 15.273, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 6
                        new BezierCurve(
                                new Point(19.365, 15.273, Point.CARTESIAN),
                                new Point(61.092, 24.818, Point.CARTESIAN),
                                new Point(59.456, 7.636, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 7
                        new BezierLine(
                                new Point(59.456, 7.636, Point.CARTESIAN),
                                new Point(21.001, 6.818, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 8
                        new BezierCurve(
                                new Point(21.001, 6.818, Point.CARTESIAN),
                                new Point(27.819, 34.636, Point.CARTESIAN),
                                new Point(10.092, 36.273, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 9
                        new BezierCurve(
                                new Point(10.092, 36.273, Point.CARTESIAN),
                                new Point(17.456, 62.455, Point.CARTESIAN),
                                new Point(40.638, 66.000, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 10
                        new BezierLine(
                                new Point(40.638, 66.000, Point.CARTESIAN),
                                new Point(9.547, 36.273, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 11
                        new BezierCurve(
                                new Point(9.547, 36.273, Point.CARTESIAN),
                                new Point(11.729, 59.455, Point.CARTESIAN),
                                new Point(38.729, 67.364, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 12
                        new BezierLine(
                                new Point(38.729, 67.364, Point.CARTESIAN),
                                new Point(9.547, 35.727, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90))
                .addPath(
                        // Line 13
                        new BezierCurve(
                                new Point(9.547, 35.727, Point.CARTESIAN),
                                new Point(18.819, 66.000, Point.CARTESIAN),
                                new Point(41.729, 67.364, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(90)).build();


        waitForStart();
        // Feedback to Driver Hub

        while (opModeIsActive()){
            follower.update();

        }
        telemetry.addData("path state", pathState);
        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", follower.getPose().getHeading());
        telemetry.update();
    }
}
