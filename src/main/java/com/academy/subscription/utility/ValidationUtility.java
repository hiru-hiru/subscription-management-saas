package com.academy.subscription.utility;

import lombok.NoArgsConstructor;


public final class ValidationUtility {

    private ValidationUtility(){}

    public static void validatePercentage(double percentage, String fieldName) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException(
                    fieldName + " must be between 0 and 100"
            );
        }
    }

}
