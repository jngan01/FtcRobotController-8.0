package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class AutoBean extends LinearOpMode {
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor uppyAndDown;
    private CRServo spinMeRightRound;
    private CRServo claw;

    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        uppyAndDown = hardwareMap.dcMotor.get("lift");
        spinMeRightRound = hardwareMap.crservo.get("duckGoSpin");
        claw = hardwareMap.crservo.get("clawIntake");

        waitForStart();

        leftBack.setPower(.5);
        sleep(1000);
        leftBack.setPower(0);
    }



}

