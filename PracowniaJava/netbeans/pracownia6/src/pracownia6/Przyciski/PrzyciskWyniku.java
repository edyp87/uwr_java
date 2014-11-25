package pracownia6.Przyciski;

import pracownia6.Processor.Processor;

public class PrzyciskWyniku implements IPrzycisk
{
    public PrzyciskWyniku(Processor p_processor)
    {
        m_processor = p_processor;
    }

    @Override
    public void wcisnij()
    {
        m_processor.wykonajDzialanie();
    }
    
    private Processor m_processor = null;
}
