package lotto.view;

import lotto.model.LottoNumbers;
import lotto.model.PurchaseAmount;
import lotto.util.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.constants.ErrorMessage.*;
import static lotto.view.OutputView.*;
import static lotto.view.OutputView.printInputWinningLottoNumbersGuideMessage;

public class InputView {
  private static final String SPLIT_DELIMITER = ",";
  private static Pattern numberPattern = Pattern.compile("\\d+");

  public static PurchaseAmount inputPurchaseAmount() {
    printInputPurchaseAmountGuideMessage();
    return inputPurchaseAmountAndVerify();
  }

  public static LottoNumbers inputWinningLottoNumbers() {
    printInputWinningLottoNumbersGuideMessage();
    return inputWinningLottoNumbersAndVerify();
  }

  private static PurchaseAmount inputPurchaseAmountAndVerify() {
    String input = InputUtils.readLine();
    try {
      checkNullOrEmpty(input);
      checkStringIsNumber(input);
      return new PurchaseAmount(parseInt(input));
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputPurchaseAmountAndVerify();
    }
  }

  private static LottoNumbers inputWinningLottoNumbersAndVerify() {
    String input = InputUtils.readLine();
    try {
      String[] splitedString = getSplitedString(input);
      List<Integer> lottoNumbers = getLottoNumbers(splitedString);
      return new LottoNumbers(lottoNumbers);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputWinningLottoNumbersAndVerify();
    }
  }

  private static List<Integer> getLottoNumbers(String[] splitedString) {
    checkSplitedStringIsNumber(splitedString);
    List<Integer> lottoNumbers = new ArrayList<>();
    for (String numberString : splitedString) {
      lottoNumbers.add(parseInt(numberString));
    }
    return lottoNumbers;
  }

  private static String[] getSplitedString(String input) {
    checkNullOrEmpty(input);
    checkSplitByComma(input);
    String[] splitedString = input.split(SPLIT_DELIMITER);
    return splitedString;
  }

  private static void checkSplitedStringIsNumber(String[] splitedString) {
    for (String numberString : splitedString) {
      checkStringIsNumber(numberString);
    }
  }

  private static void checkNullOrEmpty(String input) {
    if (input == null || input.isEmpty()) {
      throw new NullPointerException(INPUT_EMPTY_ERROR_MESSAGE);
    }
  }

  private static int parseInt(String input) {
    return Integer.parseInt(input);
  }

  public static void checkStringIsNumber(String string) {
    if (!numberPattern.matcher(string).matches()) {
      throw new NumberFormatException();
    }
  }

  private static void checkSplitByComma(String input) {
    if (!input.contains(SPLIT_DELIMITER)) {
      throw new IllegalArgumentException();
    }
  }
}
