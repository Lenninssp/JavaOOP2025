package week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Calculator {
    private final ArrayList<Double> numbers;

    public Calculator(ArrayList<Double> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public String Mean() {
        if (numbers.isEmpty()) {
            return "The list is empty, cannot compute the mean.";
        }
        double sum = 0;
        for (Double number : numbers) {
            sum += number;
        }
        return "This is the mean " + sum / numbers.size();

    }

    public String Median() {
        if (numbers.isEmpty()) {
            return "The list is empty, cannot compute the mean.";
        }
        int middle = numbers.size() / 2;
        if (numbers.size()%2 == 1 ) {
            return "This is the median " +  numbers.get(middle);
        }
        else {
            return "This is the median " +  (numbers.get(middle - 1) + numbers.get(middle))/2.0;
        }
    }

    public String Mode() {
        if (numbers.isEmpty()) {
            return "The list is empty, cannot compute the mean.";
        }
        double maxValue = 0, maxCount = 0;

        for (int i = 0; i < numbers.size(); ++i) {
            int count = 0;
            for (int j = 0; j < numbers.size(); ++j) {
                if (Objects.equals(numbers.get(j), numbers.get(i))) ++count  ;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = numbers.get(i);
            }
        }

        return "This is the mode " + maxValue;

    }
}
