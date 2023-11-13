package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.Util.Validation;

public class InputView {
    public static int getVisitDate() {
        int visitDate;

        try {
            String input = Console.readLine();
            visitDate = Validation.validateVisitDate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            visitDate = getVisitDate();
        }

        return visitDate;
    }
}
