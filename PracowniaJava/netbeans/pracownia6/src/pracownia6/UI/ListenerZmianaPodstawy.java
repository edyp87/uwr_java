package pracownia6.UI;

import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigInteger;

public class ListenerZmianaPodstawy  implements ItemListener
{
    ListenerZmianaPodstawy(Checkbox p_radioButton, KalkulatorUI p_kalkulator)
    {
        m_radioButton = p_radioButton;
        m_kalkulator  = p_kalkulator;
    }
    
    @Override
    public void itemStateChanged(ItemEvent p_event)
    {
        if(p_event.getStateChange() == ItemEvent.SELECTED)
        {
            System.out.println(p_event.getItem().toString());
            m_kalkulator.ustawPodstawe(p_event.getItem().toString());
            m_kalkulator.m_poleTekstoweGlowne.setText(m_kalkulator.konwertuj(m_kalkulator.pobierzWynik()));
            m_kalkulator.m_poleTekstowePomocnicze.setText(m_kalkulator.konwertuj(m_kalkulator.pobierzZachowanyWynik()));
        }
    }
    
    private Checkbox m_radioButton = null;
    private KalkulatorUI m_kalkulator = null;
    
}
