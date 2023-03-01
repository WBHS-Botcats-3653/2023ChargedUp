package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
//import frc.robot.subsystems.SI;

public class DumpBucket {
    private static DumpBucket m_singleton = null;

    private OI m_input;

    //private SI m_sensors;

    private WPI_VictorSPX m_bucketWinch;

    private DumpBucket() {
        m_input = OI.getInstance();

        //m_sensors = SI.getInstance();

        m_bucketWinch = new WPI_VictorSPX(1);

        // sets the motors to coast mode
        m_bucketWinch.setNeutralMode(NeutralMode.Brake);

        m_bucketWinch.setInverted(true);
    }

    // returns an instance of DumpBucket, creating an instance only when one does not already exist
    public static DumpBucket getInstance() {
        if (m_singleton == null) {
            m_singleton = new DumpBucket();
        }
        return m_singleton;
    }

    public void dumpBucketPeriodic() {
        // operator controls
        if (m_input.getP2RightTriggerAxis() > 0) {
            m_bucketWinch.set(0.4);
        }
        else if (m_input.getP2LeftTriggerAxis() > 0)
        {
            m_bucketWinch.set(-0.7);
        } else {
            m_bucketWinch.set(0);
        }

        // sends the bucket down when the top limit switch is triggered
        if (SI.topSwitchDown()) {
            m_bucketWinch.set(0.4);
        }

        // stops the bucker when the bottom limit switch is triggered
        if (SI.bottomSwitchDown()) {
            m_bucketWinch.set(0);
        }
    }

    public void dumpBucketDisabled() {
        m_bucketWinch.set(0);
    }
}
