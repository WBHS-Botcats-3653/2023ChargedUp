package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class DumpBucket {
    private static DumpBucket m_singleton = null;

    private OI m_input;

    private WPI_VictorSPX m_bucketWinch;

    private boolean isComingFromStartingPosition;
    private boolean isDumpFinished;

    private DumpBucket() {
        m_input = OI.getInstance();

        m_bucketWinch = new WPI_VictorSPX(1);

        // sets the motors to brake mode
        m_bucketWinch.setNeutralMode(NeutralMode.Brake);

        m_bucketWinch.setInverted(false);

        isComingFromStartingPosition = true; 
        isDumpFinished = false;
    }

    // returns an instance of DumpBucket, creating an instance only when one does not already exist
    public static DumpBucket getInstance() {    
        if (m_singleton == null) {
            m_singleton = new DumpBucket();
        }
        return m_singleton;
    }

    public void dumpBucketPeriodic() {
        // operator inputs
        if (m_input.getP2RightTriggerAxis() > 0.1) {
            // sends the bucket up on right trigger
            m_bucketWinch.set(-0.55);
        }
        else if (m_input.getP2LeftTriggerAxis() > 0.1) {
            // sends the bucket down on left trigger
            m_bucketWinch.set(0.3);
        } else {
            // stops the bucket when no operator or sensor inputs are occuring
            m_bucketWinch.set(0);
        }
    }

    public void dumpBucketAutonomous() {
        //if (SI.topSwitchDown()) {
        //    // sends the bucket down when the top limit switch is triggered
        //    m_bucketWinch.set(0.3);
        //    isComingFromStartingPosition = false;
        //} else if (SI.bottomSwitchDown() && !isComingFromStartingPosition){
        //    // stops the bucket when the bottom limit switch is triggered
        //    m_bucketWinch.set(0);
        //    isDumpFinished = true;
        //} else if (isComingFromStartingPosition && SI.topSwitchUp()) {
        //    // sends the bucket up by default
        //    m_bucketWinch.set(-0.6);
        //    if (Constants.getTime() > 1.5) isComingFromStartingPosition = false;
        //} else {
        //    m_bucketWinch.set(0);
        //}
        
        if (isComingFromStartingPosition) {
            m_bucketWinch.set(-0.45);
        } else if (!isComingFromStartingPosition && !isDumpFinished) {
            m_bucketWinch.set(0.2);
        } else if (isDumpFinished) {
            m_bucketWinch.set(0);
        } else {
            m_bucketWinch.set(0);
        }

        if (Constants.getTime() > 1.5) {
            isComingFromStartingPosition = false;
        } else if (Constants.getTime() > 2) {
            isDumpFinished = true;
        }
    }

    public void dumpBucketDisabled() {
        m_bucketWinch.set(0);
    }

    public boolean isComingFromStartingPosition() {
        return isComingFromStartingPosition;
    }

    public boolean isDumpFinished() {
        return isDumpFinished;
    }
}
