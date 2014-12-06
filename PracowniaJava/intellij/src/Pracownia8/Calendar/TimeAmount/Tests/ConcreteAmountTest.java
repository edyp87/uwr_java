package Pracownia8.Calendar.TimeAmount.Tests;

import Pracownia8.Calendar.TimeAmount.DaysAmount;
import Pracownia8.Calendar.TimeAmount.ITimeAmount;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConcreteAmountTest
{
    @Before
    public void setUp()
    {
        m_concreteAmount = new DaysAmount();
    }

    @Test
    public void canCreateClass()
    {

    }

    @Test
    public void returnsZeroForJustCreatedClass()
    {
        assertEquals(0, m_concreteAmount.getNumberOf());
    }

    @Test
    public void canSetNumberOfDays()
    {
        assertEquals(0, m_concreteAmount.getNumberOf());
        m_concreteAmount.setNumberOf(10);
        assertEquals(10, m_concreteAmount.getNumberOf());
    }

    @Test
    public void canCalculateDifferences()
    {
        m_concreteAmount.setNumberOf(11);
        assertEquals(11, m_concreteAmount.getNumberOf());
        DaysAmount l_otherConcreteAmount = new DaysAmount();
        l_otherConcreteAmount.setNumberOf(248);
        assertEquals(248, l_otherConcreteAmount.getNumberOf());

        assertEquals(237,  m_concreteAmount.differenceTo(l_otherConcreteAmount));
        assertEquals(-237, l_otherConcreteAmount.differenceTo(m_concreteAmount));
    }

    ITimeAmount m_concreteAmount;

}