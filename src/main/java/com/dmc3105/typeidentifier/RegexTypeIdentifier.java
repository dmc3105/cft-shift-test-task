package com.dmc3105.typeidentifier;

public class RegexTypeIdentifier implements TypeIdentifier {
    private static final String FLOAT_REGEX = "^[-+]?(\\d*\\.)?\\d+([eE][-+]?\\d+)?$";
    private static final String INTEGER_REGEX = "^[-+]?\\d+$";



    @Override
    public Type identify(String value) {
        if (isInteger(value)){
            return Type.INTEGER;
        } else if (isFloat(value)) {
            return Type.FLOAT;
        }
        return Type.STRING;
    }



    private boolean isFloat(String value)
    {
        return value.matches(FLOAT_REGEX);
    }

    private boolean isInteger(String value)
    {
        return value.matches(INTEGER_REGEX);
    }
}
