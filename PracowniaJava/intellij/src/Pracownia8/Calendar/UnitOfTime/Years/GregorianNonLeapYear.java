package Pracownia8.Calendar.UnitOfTime.Years;

import Pracownia8.Calendar.TimeAmount.DaysAmount;
import Pracownia8.Calendar.TimeAmount.ITimeAmount;
import Pracownia8.Calendar.TimeAmount.YearsAmount;

public class GregorianNonLeapYear extends GregorianYear
{
    public GregorianNonLeapYear()
    {
        m_numOfDaysInFeb.setNumberOf(28);
        m_numOfDaysInYear.setNumberOf(365);
        m_isLeap = false;
    }


    public ITimeAmount previous()
    {
        return new YearsAmount();
    }

    public ITimeAmount next()
    {
        return new YearsAmount();
    }

    public void timeTo(ITimeAmount p_time)
    {

    }

    public void timeFrom(ITimeAmount p_time)
    {

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
}
