package com.example.lab2

import kotlin.math.sqrt

public class QuadraticEquation
{
    public var A: Double = 0.0;
    public var B: Double = 0.0;
    public var C: Double = 0.0;

    public fun Calculate() : QuadraticEquationResult
    {
        var d : Double = B * B - 4 * A * C;
        var sqrtD : Double = sqrt(d);
        var x1 : Double = (-B + sqrtD) / (2 * A);
        var x2 : Double = (-B - sqrtD) / (2 * A);
        return QuadraticEquationResult(x1, x2);
    }
}

public class QuadraticEquationResult(public val X1: Double, public val X2: Double) {
}
