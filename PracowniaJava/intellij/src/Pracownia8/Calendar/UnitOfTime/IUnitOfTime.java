package Pracownia8.Calendar.UnitOfTime;

import Pracownia8.Calendar.TimeAmount.ITimeAmount;

/**
 * This is an interface to all time level of abstraction
 * such like Year, Month or Day.
 */
public interface IUnitOfTime
{
    public ITimeAmount previous();
    public ITimeAmount next();
    public void timeTo(ITimeAmount p_time);
    public void timeFrom(ITimeAmount p_time);
}
