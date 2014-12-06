package Pracownia8.Calendar.UnitOfTime.Years;

import Pracownia8.Calendar.TimeAmount.DaysAmount;
import Pracownia8.Calendar.UnitOfTime.IUnitOfTime;

/**
 * Created by Marek on 2014-12-06.
 */
public interface GregorianYear extends IUnitOfTime
{
    public boolean isLeap();
    public DaysAmount numberOfDaysInFeb();
    public DaysAmount numberOfDays();
}
