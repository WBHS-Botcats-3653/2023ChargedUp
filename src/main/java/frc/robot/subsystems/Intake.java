/*package frc.robot.subsystems;

import static frc.robot.Constants.*;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class Intake {
    private static Intake m_singleton = null;

    private OI m_input;

    private WPI_VictorSPX m_leftPivot, m_rightPivot, m_lowerRoller, m_upperRoller;

    double m_intakeOnSpeed;
    double m_intakeOffSpeed;
    boolean m_activeRollers;

    private Intake() {
        m_input = OI.getInstance();

        m_leftPivot = new WPI_VictorSPX(kLeftPivotChannel);
        m_rightPivot = new WPI_VictorSPX(kRightPivotChannel);
        m_lowerRoller = new WPI_VictorSPX(kLowerRollerChannel);
        m_upperRoller = new WPI_VictorSPX(kUpperRollerChannel);

        //sets the motors to coast mode
        m_leftPivot.setNeutralMode(NeutralMode.Coast);
        m_rightPivot.setNeutralMode(NeutralMode.Coast);
        m_lowerRoller.setNeutralMode(NeutralMode.Coast);
        m_upperRoller.setNeutralMode(NeutralMode.Coast);

        //invert the right side motors.
        m_rightPivot.setInverted(true);
    }

    //returns an instance of Intake, creating an instance only when one does not already exist
    public static Intake getInstance() {
        if (m_singleton == null) {
            m_singleton = new Intake();
        }
        return m_singleton;
    }*/

    /**
     * intake controls logic overview: 
     * 
     * if the right trigger is pressed it should move the pivot down with speed relative to the trigger's depth and set the rollers to max speed
     *    
     * if the left trigger is pressed it should move the pivot up with speed relative to the trigger's depth and set the rollers to no speed
     *
     * if no trigger is pressed it should set the pivot to no speed and the rollers speed according to the last pressed input
     */
    /*public void intakePeriodic() {
        m_intakeOnSpeed = m_input.getP1RightTriggerAxis();
        m_intakeOffSpeed = m_input.getP1LeftTriggerAxis();

        // checks to see if the right trigger is pressed at all to start intaking
        if (m_intakeOnSpeed > 1) {
            // sets the pivot speeds to be relative to the right trigger's depth
            m_leftPivot.set(m_intakeOnSpeed);
            m_rightPivot.set(m_intakeOnSpeed);

            // tells the rollers to activate
            m_activeRollers = true;
        }

        // checks to see if the left trigger is pressed at all to stop intaking
        if (m_intakeOffSpeed > 1) {
            // sets the pivot speeds to be relative to the left trigger's depth
            m_leftPivot.set(-m_intakeOffSpeed);
            m_rightPivot.set(-m_intakeOffSpeed);

            // tells the rollers to deactivate
            m_activeRollers = false;
        }

        // checks what the last trigger that was pressed was to see if the rollers should be active or not
        if (m_activeRollers) {
            //sets the rollers to max speed
            m_lowerRoller.set(1);
            m_upperRoller.set(1);
        }
        else {
            // sets the rollers to zero speed
            m_lowerRoller.set(0);
            m_upperRoller.set(0);
        }

        // sets the pivot speeds to zero/turns them off while there is no trigger pressed
        m_leftPivot.set(0);
        m_rightPivot.set(0);
    }
}*/
