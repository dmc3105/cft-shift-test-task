package com.dmc3105;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;
import com.dmc3105.typeidentifier.*;

public class RegexTypeIdentifierTest {
    private final TypeIdentifier typeIdentifier = new RegexTypeIdentifier();



    @ParameterizedTest(name = "identify_{0}_returnsFloat")
    @ValueSource(strings = {"14.1", "-142.12", "+4.5", ".67", "+.221", "-.3", "1.4e5", ".3E-4", "1.528535047E-25", "3.1415", "-0.001"})
    void identify_params_returnsFloat(String value)
    {
        Type result = typeIdentifier.identify(value);
        Assertions.assertEquals(Type.FLOAT, result);
    }

    @ParameterizedTest(name = "identify_{0}_returnsInteger")
    @ValueSource(strings = {"3", "+2", "-12", "0", "45", "1234567890123456789", "100500"})
    void identify_params_returnsInteger(String value)
    {
        Type result = typeIdentifier.identify(value);
        Assertions.assertEquals(Type.INTEGER, result);
    }

    @ParameterizedTest(name = "identify_{0}_returnsString")
    @ValueSource(strings = {
            "Lorem ipsum dolor sit amet",
            "Нормальная форма числа с плавающей запятой",
            "Пример",
            "Long",
            "consectetur adipiscing",
            "тестовое задание"})
    void identify_params_returnsString(String value)
    {
        Type result = typeIdentifier.identify(value);
        Assertions.assertEquals(Type.STRING, result);
    }
}
