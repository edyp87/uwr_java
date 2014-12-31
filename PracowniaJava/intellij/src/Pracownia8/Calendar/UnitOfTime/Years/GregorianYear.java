package Pracownia8.Calendar.UnitOfTime.Years;

import Pracownia8.Calendar.TimeAmount.DaysAmount;
import Pracownia8.Calendar.UnitOfTime.IUnitOfTime;

/**
 * Created by Marek on 2014-12-06.
 */
public abstract class GregorianYear implements IUnitOfTime
{
    public GregorianYear()
    {
        m_numOfDaysInFeb = new DaysAmount();
        m_numOfDaysInFeb.setNumberOf(28);
        m_numOfDaysInYear = new DaysAmount();
        m_numOfDaysInYear.setNumberOf(365);
        m_isLeap = true;
    }

    public boolean isLeap()
    {
        return m_isLeap;
    }
    public DaysAmount numberOfDaysInFeb()
    {
        return m_numOfDaysInFeb;
    }
    public DaysAmount numberOfDays()
    {
        return m_numOfDaysInYear;
    }

    DaysAmount m_numOfDaysInFeb;
    DaysAmount m_numOfDaysInYear;
    boolean m_isLeap;
}
