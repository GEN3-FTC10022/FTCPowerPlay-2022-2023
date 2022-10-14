package org.firstinspires.ftc.teamcode.opmode.teleOp;

// imports form opMode package
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// imports form util and subsystem package
import org.firstinspires.ftc.teamcode.util.subsystem;
import org.firstinspires.ftc.teamcode.subsystem.driveTrain;


@TeleOp
public class test_teleOp extends LinearOpMode{

    // variables for drivetrain
    double rx =0;
    double y = 0;
    double x = 0;
    double speed = 2;
    @Override

    public void runOpMode() {

        // console log
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // runs the initialization of subsystem and driveTrain class
        subsystem.initialize(hardwareMap, telemetry);
        driveTrain.initialize();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // driveTrain move while opMode is Active
        while (opModeIsActive()) {

            // set the speed to lower the speed
            if (gamepad1.right_trigger >0){
                speed = 1;
            }

            // get the values will get from gamepad time the speed values
            y = gamepad1.left_stick_y * speed;
            rx  = -gamepad1.right_stick_x * speed;
            x = -gamepad1.left_stick_x * speed;

            // use the move method with the values
            driveTrain.move(y,x,rx);


        }
    }
}
