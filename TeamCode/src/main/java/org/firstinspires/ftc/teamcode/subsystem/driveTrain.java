package org.firstinspires.ftc.teamcode.subsystem;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.util.subsystem;


public class driveTrain extends subsystem {

    // variable name for motors
    public static DcMotor FlDrive, FrDrive, BlDrive, BrDrive;

    // Constants
    private static final double WHEEL_DIAMETER_INCHES = 4;
    private static final double WHEEL_CIRCUMFERENCE_INCHES = WHEEL_DIAMETER_INCHES * Math.PI;
    private static final double TICKS_PER_REV = 537.6;
    private static final double GEAR_REDUCTION = 1;
    private static final double TICKS_PER_INCH = (TICKS_PER_REV * GEAR_REDUCTION) / WHEEL_CIRCUMFERENCE_INCHES;
    private static final double INCHES_PER_DEGREE = 70.0/360;


    // hardWareMap initialize for driveTrain teleOp
    public static void initialize(){
        FlDrive = hm.get(DcMotor.class, "Fl");
        FrDrive = hm.get(DcMotor.class, "Fr");
        BlDrive = hm.get(DcMotor.class, "Bl");
        BrDrive = hm.get(DcMotor.class, "Br");
        FlDrive.setDirection(DcMotor.Direction.REVERSE);
        BlDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    // hardWareMap initialize for driveTrain auto
    public static void AutoInitialize(){
        FlDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BlDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BrDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    // method for mecanum drive
    public static void move(double y, double x, double rx){
        double max = Math.max(Math.abs(y)+Math.abs(x)+Math.abs(rx),1);
        double fl = (y + x +rx)/max;
        double bl = (y - x + rx)/max;
        double fr = (y - x -rx)/max;
        double br = (y + x -rx)/max;
        FlDrive.setPower(fl);
        BlDrive.setPower(bl);
        FrDrive.setPower(fr);
        BrDrive.setPower(br);

        tm.addLine("fl: " + fl);
        tm.addLine("bl: " + bl);
        tm.addLine("fr: " + fr);
        tm.addLine("br: " + br);

        tm.update();
        Zero();

    }
    // method to stop driveTrain
    public static void Zero(){
        FlDrive.setPower(0);
        BlDrive.setPower(0);
        FrDrive.setPower(0);
        BrDrive.setPower(0);
    }


}
