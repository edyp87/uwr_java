package pracownia6.Przyciski;

import java.math.BigInteger;

public interface IPrzyciskDzialaniaBinarnego extends IPrzycisk
{
    public BigInteger wykonajDzialanie(BigInteger p_lewyArgument, BigInteger p_prawyArgument) throws Exception;
    @Override
    public String toString();
}
