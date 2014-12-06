package Pracownia8.Calendar.UnitOfTime.Years;

import Pracownia8.Calendar.TimeAmount.DaysAmount;
import Pracownia8.Calendar.TimeAmount.ITimeAmount;
import Pracownia8.Calendar.TimeAmount.YearsAmount;

public class GregorianLeapYear implements GregorianYear
{
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
        return false;
    }

    public DaysAmount numberOfDaysInFeb()
    {
        DaysAmount l_daysInFeb = new DaysAmount();
        l_daysInFeb.setNumberOf(28);
        return l_daysInFeb;
    }

    public DaysAmount numberOfDays()
    {
        DaysAmount l_daysInFeb = new DaysAmount();
        l_daysInFeb.setNumberOf(365);
        return l_daysInFeb;
    }
}
