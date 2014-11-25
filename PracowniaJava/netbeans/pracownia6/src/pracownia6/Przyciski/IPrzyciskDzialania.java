package pracownia6.Przyciski;

import java.math.BigInteger;

public interface IPrzyciskDzialania extends IPrzycisk
{
    public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument);
}
