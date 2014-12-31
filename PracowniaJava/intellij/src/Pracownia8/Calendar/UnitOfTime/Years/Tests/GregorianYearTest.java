package Pracownia8.Calendar.UnitOfTime.Years.Tests;


import Pracownia8.Calendar.UnitOfTime.Years.GregorianLeapYear;
import Pracownia8.Calendar.UnitOfTime.Years.GregorianNonLeapYear;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GregorianYearTest
{
    @Before
    public void setUp()
    {
        m_greogrianLeapYear = new GregorianLeapYear();
        m_greogrianNonLeapYear = new GregorianNonLeapYear();
    }

    @Test
    public void leapYearRetunrsCorrectNumberOfDays()
    {
        assertEquals(29, m_greogrianLeapYear.numberOfDaysInFeb().getNumberOf());
        assertEquals(366, m_greogrianLeapYear.numberOfDays().getNumberOf());
    }

    @Test
    public void nonLeapYearRetunrsCorrectNumberOfDays()
    {
        assertEquals(28, m_greogrianNonLeapYear.numberOfDaysInFeb().getNumberOf());
        assertEquals(365, m_greogrianNonLeapYear.numberOfDays().getNumberOf());
    }

    @Test
    public void nonLeapYearRetunrsCorrectLeapStatus()
    {
        assertFalse(m_greogrianNonLeapYear.isLeap());
    }

    @Test
    public void leapYearRetunrsCorrectLeapStatus()
    {
        assertTrue(m_greogrianLeapYear.isLeap());
    }

    GregorianLeapYear m_greogrianLeapYear;
    GregorianNonLeapYear m_greogrianNonLeapYear;

}
