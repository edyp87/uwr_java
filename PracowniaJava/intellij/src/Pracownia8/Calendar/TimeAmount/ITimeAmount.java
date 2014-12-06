package Pracownia8.Calendar.TimeAmount;

/**
 * This is an interface to classes which represent time amount,
 * for example number of days, number of minutes etc.
 */
public interface ITimeAmount
{
    public int getNumberOf();
    public void setNumberOf(int p_numberOfDays);
    public int differenceTo(ITimeAmount p_otherAmount);
    public String toString();
}
