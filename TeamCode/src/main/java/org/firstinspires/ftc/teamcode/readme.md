## TeamCode Module
 

TODO 

* set encoder names in hardWareMap
* 
* https://learnroadrunner.com/dead-wheels.html#tuning-three-wheel

  public static double LATERAL_DISTANCE = 10; // in; distance between the left and right wheels
  public static double FORWARD_OFFSET = 4; // in; offset of the lateral wheel

/* Lines 46-63~ in StandardTrackingWheelLocalizer.java */

  leftEncoder = new Encoder(hardwareMap.get(DcMotorEx.class, "leftEncoder"));

  // If you need to reverse the middle encoder:

  // Vice-versa for the other encoders
  frontEncoder.setDirection(Encoder.Direction.REVERSE);

/* Lines 46-47 in TwoWheelTrackingLocalizer.java */
public static double X_MULTIPLIER = 1; // Multiplier in the X direction
public static double Y_MULTIPLIER = 1; // Multiplier in the Y direction
  
* driver constants
  https://learnroadrunner.com/drive-constants.html#wheel-radius-gear-ratio-trackwidth