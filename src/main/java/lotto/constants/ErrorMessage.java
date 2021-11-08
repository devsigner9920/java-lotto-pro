package lotto.constants;

public class ErrorMessage {
  public static final String ERROR_PREFIX = "[Error] ";
  public static final String PURCHASE_AMOUNT_LOWER_ERROR_MESSAGE =
    ERROR_PREFIX + "로또 가격보다 낮은 가격을 입력할 수 없습니다.";
  public static final String INPUT_EMPTY_ERROR_MESSAGE =
    ERROR_PREFIX + "공백을 입력할 수 없습니다.";
  public static final String ILLEGAL_LOTTO_NUMBER_ERROR =
    ERROR_PREFIX + "로또 숫자 범위를 벗어나 입력하였습니다.";
  public static final String LOTTO_NUMBERS_RANGE_ERROR =
    ERROR_PREFIX + "로또는 6개의 숫자로 구성되어 있습니다.";
  public static final String LOTTO_NUMBER_DUPLICATE_ERROR =
    ERROR_PREFIX + "로또 숫자를 중복되어 입력할 수 없습니다.";
}
