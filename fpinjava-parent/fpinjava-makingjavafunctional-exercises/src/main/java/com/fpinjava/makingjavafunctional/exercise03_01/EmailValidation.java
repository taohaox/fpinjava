package com.fpinjava.makingjavafunctional.exercise03_01;


import com.fpinjava.common.Function;

import java.util.regex.Pattern;

public class EmailValidation {

    static Pattern emailPattern =
            Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static Function<String, Result<String>> emailChecker = s -> {
        if (s == null) {
            return Result.failure("email must not be null");
        } else if ("".equals(s)) {
            return Result.failure("email must not be empty");
        }
        return emailPattern.matcher(s).matches()?Result.success(s):Result.failure("email "+s+" is invalid");
    };

    public static void main(String... args) {
        emailChecker.apply("this.is@my.email").bind(success, failure);
        emailChecker.apply(null).bind(success, failure);
        emailChecker.apply("").bind(success, failure);
        emailChecker.apply("john.doe@acme.com").bind(success, failure);


        Function<Double,Function<Double,Double>> compute = x->y->x-x*y;
        System.out.println(compute.apply(10000d).apply(0.2));
        Function<Double, Double> apply = compute.apply(10000d);
        Double apply1 = apply.apply(0.3);
        System.out.println(apply.apply(0.3));
        System.out.println(apply.apply(0.4));

    }

    static Effect<String> success = s-> System.out.println("mail send to "+s);

    static Effect<String> failure = s-> System.err.println("error message logged:"+s);
}