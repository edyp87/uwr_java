package pracownia6.Przyciski;

import pracownia6.Processor.Processor;

public class PrzyciskC implements IPrzycisk
{
    public PrzyciskC(Processor p_processor)
    {
        m_processor = p_processor;
    }

    @Override
    public void wcisnij()
    {
        m_processor.resetujProcessor();
        
    }
    
    private Processor m_processor = null;
}
