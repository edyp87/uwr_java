package Pracownia8.Calendar.UnitOfTime.Years;

import Pracownia8.Calendar.TimeAmount.DaysAmount;
import Pracownia8.Calendar.TimeAmount.ITimeAmount;
import Pracownia8.Calendar.TimeAmount.YearsAmount;

public class GregorianNonLeapYear implements GregorianYear
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
        return true;
    }

    public DaysAmount numberOfDaysInFeb()
    {
        DaysAmount l_daysInFeb = new DaysAmount();
        l_daysInFeb.setNumberOf(29);
        return l_daysInFeb;
    }

    public DaysAmount numberOfDays()
    {
        DaysAmount l_daysInFeb = new DaysAmount();
        l_daysInFeb.setNumberOf(366);
        return l_daysInFeb;
    }
}
