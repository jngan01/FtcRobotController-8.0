package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class justinJellyMop extends OpMode {
    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;
    private DcMotor topLift;
    private DcMotor bottomLift;
    private DcMotor fourBar;
    private CRServo claw;

    @Override
    // On initialization
    public void init() {

        leftFront = hardwareMap.dcMotor.get("leftFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        rightBack = hardwareMap.dcMotor.get("rightBack");
        topLift = hardwareMap.dcMotor.get("liftTop");
        bottomLift = hardwareMap.dcMotor.get("liftBottom");
        fourBar = hardwareMap.dcMotor.get("fourBar");
        claw = hardwareMap.crservo.get("clawIntake");
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addLine("Initialized"); // Text shown on phone that says "Initialized"
    }

    @Override
    //While program is running
    public void loop() {
        /* leftFront.setPower(-gamepad1.left_stick_y);
        leftBack.setPower(-gamepad1.left_stick_y);
        rightFront.setPower(-gamepad1.right_stick_y);
        rightBack.setPower(-gamepad1.right_stick_y); */
// claw
        if(gamepad1.a){
            claw.setPower(.25);
        }else if(gamepad1.b){
            claw.setPower(-.25);
        }else if (!gamepad1.a && !gamepad1.b){
            claw.setPower(0);
        }
// lift
        topLift.setPower(gamepad1.left_trigger * .5);
        bottomLift.setPower(gamepad1.left_trigger * .5);
        topLift.setPower(-gamepad1.left_trigger * .5);
        bottomLift.setPower(-gamepad1.left_trigger * .5);
//four bar
        if(gamepad1.y){
            fourBar.setPower(.75);
        }else if(gamepad1.x){
            fourBar.setPower(-.75);
        }else if(!gamepad1.y && !gamepad1.x){
            fourBar.setPower(0);
        }
// drive
        if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
            leftFront.setPower(gamepad1.left_stick_x);
            leftBack.setPower(-gamepad1.left_stick_x);
            rightFront.setPower(-gamepad1.left_stick_x);
            rightBack.setPower(gamepad1.left_stick_x);
        } else if (Math.abs(gamepad1.left_stick_y) > Math.abs(gamepad1.left_stick_x)) {
            leftFront.setPower(-gamepad1.left_stick_y);
            leftBack.setPower(-gamepad1.left_stick_y);
            rightFront.setPower(-gamepad1.left_stick_y); //Problem could be here
            rightBack.setPower(-gamepad1.left_stick_y);
        } else {
            if (!gamepad1.right_bumper && !gamepad1.left_bumper && Math.abs(gamepad1.right_stick_x) <= 0.05 && Math.abs(gamepad1.right_stick_y) <= 0.05 && Math.abs(gamepad1.left_stick_x) <= 0.05 && Math.abs(gamepad1.left_stick_y) <= 0.05) {
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);
            }
        }
    }
}





