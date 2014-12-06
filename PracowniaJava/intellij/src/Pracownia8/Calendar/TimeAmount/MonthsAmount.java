package Pracownia8.Calendar.TimeAmount;


public class MonthsAmount implements ITimeAmount
{
    public MonthsAmount()
    {
        m_numberOfMonths = 0;
        m_divisor      = 1;
    }

    protected MonthsAmount(int p_divisor)
    {
        m_numberOfMonths = 0;
        m_divisor      = p_divisor;
    }

    @Override
    public int getNumberOf()
    {
        return m_numberOfMonths;
    }

    @Override
    public void setNumberOf(int p_numberOfDays)
    {
        m_numberOfMonths = p_numberOfDays;
    }

    @Override
    public int differenceTo(ITimeAmount p_otherAmount)
    {
        return p_otherAmount.getNumberOf() - m_numberOfMonths;
    }

    protected int m_numberOfMonths;
    protected int m_divisor;

}
