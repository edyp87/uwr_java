package Pracownia8.Calendar.TimeAmount;


public class YearsAmount extends MonthsAmount
{
    public YearsAmount()
    {
        super(12);
    }

    @Override
    public int getNumberOf()
    {
        return m_numberOfMonths / m_divisor;
    }

    @Override
    public void setNumberOf(int p_numberOfYears)
    {
        m_numberOfMonths = p_numberOfYears * m_divisor;
    }

    @Override
    public String toString()
    {
        return "Lat: " + m_numberOfMonths;
    }
}
