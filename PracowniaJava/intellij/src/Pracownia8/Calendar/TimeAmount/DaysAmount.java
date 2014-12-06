package Pracownia8.Calendar.TimeAmount;


public class DaysAmount implements ITimeAmount
{
    public DaysAmount()
    {
        m_numberOfDays = 0;
    }

    @Override
    public int getNumberOf()
    {
        return m_numberOfDays;
    }

    @Override
    public void setNumberOf(int p_numberOfDays)
    {
        m_numberOfDays = p_numberOfDays;
    }

    @Override
    public int differenceTo(ITimeAmount p_otherAmount)
    {
        return p_otherAmount.getNumberOf() - m_numberOfDays;
    }

    protected int m_numberOfDays;

}
