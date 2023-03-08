package frc.robot;

/** 
 * this file is used to create an easy to use and edit list of constants in the 
 * robot. Most commonly IDs and ports for electronics.
 */
public class Constants {

    /**
     * motor controller IDs
     */
    // drivetrain
    public static final int kFrontLeftWheelID = 11;
    public static final int kRearLeftWheelID = 12;
    public static final int kFrontRightWheelID = 13;
    public static final int kRearRightWheelID = 14;
    // dumpbucket
    public static final int kBucketWinchID = 1;

    // drive control accelerations
    public static final double kThrottleAcceleration = 1;
    public static final double kRotationAcceleartion = 1;

    // DIO ports
    public static final int kBottomLimitSwitchPort = 0;
    public static final int kTopLimitSwitchPort = 1;

    // gryo I2C addresses
    public static final int kGyroAddress = 0x6b; // default I2C address for L3GD20H gyro
    public static final int kRegOutX = 0x28; // register address for X-axis data
    public static final int kRegOutY = 0x2A; // register address for Y-axis data
    public static final int kRegOutZ = 0x2C; // register address for Z-axis data
    public static final int kRegCtrl1 = 0x20; // register address for control register 1
    public static final int kRegCtrl4 = 0x23; // register address for control register 4
    
    // controller port
    public static final int kP1XboxPort = 0;
    public static final int kP2XboxPort = 0;

    // divides operator input by this number in slow driving mode
    public static final double kSlowDriveCoefficient = 2;

    // this variable is actually not a constant, it is being used to roughly tell how long its been in each phase of the game 
    public static double timer = 0;

    public static void count() {
        timer += 0.02;
    }

    public static double getTime() {    
        return timer;
    }

    public static void resetTimer() {
        timer = 0;
    }
}
