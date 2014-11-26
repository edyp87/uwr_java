package pracownia6.UI;

import java.math.BigInteger;

public class KonwertujNaBin implements IKonwertuj
{
    @Override
    public String konwertuj(BigInteger p_wartosc)
    {
        return p_wartosc.toString(2);
    }
    
}
