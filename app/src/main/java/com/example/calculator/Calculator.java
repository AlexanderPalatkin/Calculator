package com.example.calculator;

public class Calculator {
    private String firstValue = "";
    private String secondValue = "";
    private String operand = "";
    private String result = "";
    private Boolean isCalculated = false;
    private Boolean isEmptySecondField = true;
    private Boolean isEmptyOperand = true;

    public String getFirstValue() {
        return firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public String getOperand() {
        return operand;
    }

    public String getResult() {
        return result;
    }

    public void getReset() {
        reset();
    }

    private void reset() {
        firstValue = "";
        secondValue = "";
        operand = "";
        result = "";
        isCalculated = false;
        isEmptySecondField = true;
        isEmptyOperand = true;
    }

    public void setField(String value) {
        if (isEmptyOperand) {
            if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                if (isCalculated) {
                    String saveResult = result.substring(2);
                    reset();
                    firstValue = saveResult;
                    isCalculated = false;
                }
                operand = value;
                isEmptyOperand = false;
                if (firstValue.length() == 0 || firstValue.equals("-") || firstValue.charAt(firstValue.length() - 1) == '.') {
                    firstValue = "0";
                }
                if (firstValue.equals("-0.0")) {
                    firstValue = firstValue.substring(1);
                }
            } else {
                if (isCalculated) {
                    reset();
                    isCalculated = false;
                }
                if (value.equals(".")) {
                    if (firstValue.length() == 0) {
                        firstValue = "0.";
                    } else if (!firstValue.contains(".")) {
                        firstValue += ".";
                    }
                } else {
                    if (firstValue.equals("0")) {
                        firstValue = firstValue + "." + value;
                    } else {
                        firstValue += value;
                    }
                }
            }
        } else {
            if (!value.equals("+") && !value.equals("-") && !value.equals("*") && !value.equals("/") && !value.equals("=")) {
                if (value.equals(".")) {
                    if (secondValue.length() == 0) {
                        secondValue += "0.";
                        isEmptySecondField = false;
                    } else if (!secondValue.contains(".")) {
                        secondValue += ".";
                        isEmptySecondField = false;
                    }
                } else {
                    if (secondValue.equals("0")) {
                        secondValue = secondValue + "." + value;
                    } else {
                        secondValue += value;
                    }
                    isEmptySecondField = false;
                }
            }
        }
        int MAX_LENGTH_VALUES = 15;
        if (firstValue.length() > MAX_LENGTH_VALUES) {
            firstValue = firstValue.substring(0, MAX_LENGTH_VALUES);
        } else if (secondValue.length() > MAX_LENGTH_VALUES) {
            secondValue = secondValue.substring(0, MAX_LENGTH_VALUES);
        }
    }

    public void getPlusMinus() {
        if (!isCalculated) {
            if (isEmptyOperand) {
                firstValue = checkPlusMinus(firstValue);
            } else {
                secondValue = checkPlusMinus(secondValue);
            }
        }
    }

    public void setResult() {
        if (secondValue.equals("-")) {
            secondValue = "0";
            isEmptySecondField = true;
        } else if (secondValue.charAt(secondValue.length() - 1) == '.') {
            secondValue += "0";
        } else if (secondValue.equals("-0.0")) {
            secondValue = secondValue.substring(1);
        }
        if (!isEmptySecondField) {
            double value1 = Double.parseDouble(firstValue);
            double value2 = Double.parseDouble(secondValue);
            double resultValue;
            switch (operand) {
                case "+": {
                    resultValue = (value1 + value2);
                    checkRemainderOfResult(resultValue);
                    isResult();
                    break;
                }
                case "-": {
                    resultValue = (value1 - value2);
                    checkRemainderOfResult(resultValue);
                    isResult();
                    break;
                }
                case "*": {
                    resultValue = (value1 * value2);
                    checkRemainderOfResult(resultValue);
                    isResult();
                    break;
                }
                case "/": {
                    resultValue = (value1 / value2);
                    checkRemainderOfResult(resultValue);
                    isResult();
                    break;
                }
            }
        }
    }

    public void backspace() {
        if (isCalculated) {
            result = "";
            secondValue = secondValue.substring(0, secondValue.length() - 1);
            isCalculated = false;
            isEmptyOperand = false;
        } else if (isEmptyOperand) {
            if (!firstValue.isEmpty()) {
                firstValue = firstValue.substring(0, firstValue.length() - 1);
            }
        } else {
            if (!secondValue.isEmpty()) {
                secondValue = secondValue.substring(0, secondValue.length() - 1);
            } else if (operand != null) {
                operand = null;
                isEmptyOperand = true;
            }
        }
        if (firstValue.equals("-0")) {
            firstValue = firstValue.substring(1);
        } else if (secondValue.equals("-0")) {
            secondValue = secondValue.substring(1);
        }
    }

    private void isResult() {
        isCalculated = true;
        isEmptyOperand = true;
    }

    private void checkRemainderOfResult(double resultValue) {
        if (resultValue % 1 != 0) {
            result = "= " + resultValue;
        } else {
            result = "= " + ((int) resultValue);
        }
    }

    private String checkPlusMinus(String value) {
        if (!(value.startsWith("0") && value.length() == 1) &&
                (!value.equals("")) &&
                (!value.equals("0."))) {
            if (!value.contains("-")) {
                return "-" + value;
            } else {
                return value.substring(1);
            }
        } else {
            return value;
        }
    }
}
