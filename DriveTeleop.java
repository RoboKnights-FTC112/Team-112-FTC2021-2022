package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */

@TeleOp

public class FinalControls extends LinearOpMode {

  private DcMotor frontl, frontr, leftb, rightb, ds, spin1, spin2;

  @Override
  public void runOpMode() {

    // This creates variables for each motor based on the configuration file
    frontl = hardwareMap.get(DcMotor.class, "fl");
    frontr = hardwareMap.get(DcMotor.class, "fr");
    leftb = hardwareMap.get(DcMotor.class, "bl");
    rightb = hardwareMap.get(DcMotor.class, "br");
    spin1 = hardwareMap.get(DcMotor.class, "s1");
    spin2 = hardwareMap.get(DcMotor.class, "s2");
    ds = hardwareMap.get(DcMotor.class, "duck");



    telemetry.addData("Status", "Initialized");
    telemetry.update();

    // Wait for the game to start (driver presses PLAY)
    waitForStart();

    // run until the end of the match (driver presses STOP)
    while (opModeIsActive()) {
      // when left stick moves forward, bot goes forward

     if (this.gamepad1.right_stick_x>0.5 && this.gamepad1.a == true){
        frontl.setPower(0.3);
        frontr.setPower(0.3);
        leftb.setPower(0.3);
        rightb.setPower(0.3);

      } else if (this.gamepad1.right_stick_x>0.5){
        //when right stick moves right, bot turns right
        leftb.setPower(.6);
        rightb.setPower(.6);
        frontl.setPower(.6);
        frontr.setPower(.6);

      } else if (this.gamepad1.right_stick_x<-0.5 && this.gamepad1.a == true){
        frontl.setPower(-0.3);
        frontr.setPower(-0.3);
        leftb.setPower(-0.3);
        rightb.setPower(-0.3);

      } else if (this.gamepad1.right_stick_x<-0.5){
        //when right stick moves left, bot turns left
        leftb.setPower(-.6);
        rightb.setPower(-.6);
        frontl.setPower(-.6);
        frontr.setPower(-.6);

      } else if (this.gamepad1.left_stick_y<-0.5 && this.gamepad1.a == true){
        frontl.setPower(0.3);
        frontr.setPower(-0.3);
        leftb.setPower(0.3);
        rightb.setPower(-0.3);


      } else if (this.gamepad1.left_stick_y<-0.5){

        frontl.setPower(0.9);
        frontr.setPower(-0.9);
        leftb.setPower(0.9);
        rightb.setPower(-0.9);

      } else if (this.gamepad1.left_stick_y>0.5 && this.gamepad1.a == true){
        frontl.setPower(-0.3);
        frontr.setPower(0.3);
        leftb.setPower(-0.3);
        rightb.setPower(0.3);

      } else if (this.gamepad1.left_stick_y>0.5) {
        // when left stick moves back, bot moves backwards
        leftb.setPower(-0.9);
        rightb.setPower(0.9);
        frontl.setPower(-0.9);
        frontr.setPower(0.9);

      } else if (this.gamepad1.right_trigger>0.5 && this.gamepad1.a == true){
        frontl.setPower(0.3);
        frontr.setPower(0.3);
        leftb.setPower(-0.3);
        rightb.setPower(-0.3);

      } else if (this.gamepad1.right_trigger>0.5){
        //when right trigger pressed, bot strafes right
        leftb.setPower(-.75);
        rightb.setPower(-.75);
        frontl.setPower(.75);
        frontr.setPower(.75);

      } else if (this.gamepad1.left_trigger>0.5 && this.gamepad1.a == true){
        frontl.setPower(-0.3);
        frontr.setPower(-0.3);
        leftb.setPower(0.3);
        rightb.setPower(0.3);

      } else if (this.gamepad1.left_trigger>0.5){
        //when left trigger pressed, bot strafes left
        leftb.setPower(.75);
        rightb.setPower(.75);
        frontl.setPower(-.75);
        frontr.setPower(-.75);

      } else {

        leftb.setPower(0);
        rightb.setPower(0);
        frontl.setPower(0);
        frontr.setPower(0);

      }
     if (this.gamepad1.x == true){
        //when x pressed, spinner turns long
        spin1.setPower(.75);
        spin2.setPower(.75);

      } else {
        spin1.setPower (0);
        spin2.setPower (0);
     }
     if (this.gamepad1.b == true){
        //when x pressed, spinner turns long
        ds.setPower(.75);

      } else {
        ds.setPower (0);
     }
    }
  }
}
