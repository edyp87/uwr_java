package pracownia6.UI;

import java.math.BigInteger;

public class KonwertujNaHex implements IKonwertuj
{
    @Override
    public String konwertuj(BigInteger p_wartosc)
    {
        return "0x" + p_wartosc.toString(16);
    }
    
}
