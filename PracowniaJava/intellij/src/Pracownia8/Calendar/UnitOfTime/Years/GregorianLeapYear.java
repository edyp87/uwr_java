package Pracownia8.Calendar.UnitOfTime.Years;

import Pracownia8.Calendar.TimeAmount.DaysAmount;
import Pracownia8.Calendar.TimeAmount.ITimeAmount;
import Pracownia8.Calendar.TimeAmount.YearsAmount;

public class GregorianLeapYear extends GregorianYear
{
    public GregorianLeapYear()
    {
        m_numOfDaysInFeb.setNumberOf(29);
        m_numOfDaysInYear.setNumberOf(366);
        m_isLeap = true;
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
