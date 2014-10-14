See the `WorstCalculator` version. There are some drawbacks:

- Tha name of variables are non-sense.
- It cannot be reused if you want to write a GUI version.
- You cannot easily extend the supported operation

I recursively refactor this code, and the sequence is:

1. `WorstCalculator`
2. `CalculatorWithMeaningfulVariableName`
    Fix non-sense variable names
3. `CalculatorUsingOperationClassAndEnum`
    Use Enum to implement operation
4. `CalculatorWithOperaionInterface`
    Use `static double getResult(String opString, double[] operands)` method to provide a **Facade**.
5. `CalculatorWithFactory`

Now, based on `CalculatorWithFactory` version, if I want to add a `mod` operator, I can do it following:

- Add new `DoubleOperation2` for `mod` operator.
- I add code in `OperationFactory` which returns `DoubleOperation2` for `mod`. 