package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class clawTest  extends OpMode{
    private CRServo clawIntake;
    private DcMotor fourBar;

    /* double reversePower = -.10;
    double resistance = -fourBar.getPower() + reversePower; */ //Weird stuff don't use
    @Override
    public void init(){
        clawIntake = hardwareMap.crservo.get("clawIntake");
        fourBar = hardwareMap.dcMotor.get("fourBar");
        fourBar.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop(){
        if(gamepad1.a){
            clawIntake.setPower(.25);
        }else if(gamepad1.b){
            clawIntake.setPower(-.25);
        }else if (!gamepad1.a && !gamepad1.b){
            clawIntake.setPower(0);
        }

        if(gamepad1.y){
            fourBar.setPower(.50);
        }else if(gamepad1.x){
            fourBar.setPower(-.15);
        }else if(!gamepad1.y && !gamepad1.x){
            fourBar.setPower(0);
        }



        }
    }

