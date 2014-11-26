package pracownia6.UI;

import java.math.BigInteger;

public class KonwertujNaDec implements IKonwertuj
{
    @Override
    public String konwertuj(BigInteger p_wartosc)
    {
        return p_wartosc.toString(10);
    }
    
}
