# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 문자열 덧셈 계산기를 통한 TDD/리팩토링 실습
### 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 기능 목록 분리
- 문자열을 쉼표(,) 또는 콜론(:)으로 분리한다.
- 문자열을 커스텀 구분자로 분리할 수 있다. (예 : “//;\n1;2;3” => 6)
- null 또는 공백 문자열이 오면 0을 반환한다. (예 : “” => 0, null => 0)
- 문자열에 숫자 하나만 입력할 경우 해당 숫자를 반환한다. (예 : “1”)
- 구분자를 기준으로 분리한 각 숫자의 합을 반환한다. (예: "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 음수를 전달하는 경우 RuntimeException 예외를 발생시킨다. (예 : “-1,2,3”)
- 숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 발생시킨다. (예 : “1,a,3”)

## 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 힌트
* 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
* Collections.sort() 메소드를 활용해 정렬 가능하다.
* ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 기능 목록
* 로또 구입금액 입력 안내 메시지를 출력한다.
* 로또 구입 금액을 입력한다.
* 숫자가 아닌 경우 에러 메시지 출력 및 재입력을 요청한다.
* 로또 구입 금액 / 1장 가격(1000원) 만큼 로또를 발급힌다.
* 구매한 장수를 출력한다.
* 계산된 로또 발급 장수에 소수점 이하가 나올 경우 거스름돈 처리한다.
* 거스름돈을 출력한다.
* 로또 번호는 1부터 45까지이다.
* 로또 번호는 1장당 6개가 존재한다.
* 로또 번호는 1장 내에서 중복될 수 없다.
* 로또 번호 생성 규칙대로 구매한 장수만큼 로또를 발급한다.
* 로또를 발급하는 방법은 '자동' 이다.
* 발급한 로또들을 `[1, 2, 3, 4, 5, 6]` 포맷으로 출력한다.
* 로또 번호 생성 규칙을 동일하게 적용하여 당첨 번호를 발급한다.
* 당첨 번호 안내 메시지를 출력한다.
* 당첨 번호를 출력한다.
* 3개 일치 5000원
* 4개 일치 50000원
* 5개 일치 1500000원
* 6개 일치 2000000000원
* 일치한 횟수를 출력한다.
* 수익률을 `일치한 금액의 합 / 구입 금액` 식으로 계산한다.
* 수익률을 출력한다.
* 1을 기준으로 손해여부를 출력한다.

## 기능 정의
### InputView
* 구입 금액을 입력 받을 수 있다.
* 입력값 검증
  * 입력값이 숫자인지 검증한다.
  * 입력값이 1000원 이상인지 검증한다.
* 예외 발생
  * OutputView에 에러 메시지를 출력을 요청한다. ex) `[ERROR] {Error message.}`
  * 구입 금액을 재입력 받는다.

### ResultView
* 메시지를 출력한다.
  - 로또 구입금액 입력 안내 메시지를 출력한다.
  - 숫자가 아닌 경우 에러 메시지 출력한다.
  - 구매한 로또 장수를 출력한다.
  - 거스름돈을 출력한다.
  - 발급한 로또들을 `[1, 2, 3, 4, 5, 6]` 포맷으로 출력한다.
  - 당첨 번호 안내 메시지를 출력한다.
  - 당첨 번호를 출력한다.
  - 번호가 일치한 횟수를 출력한다.
  - 수익률을 출력한다.
  - 손해여부를 출력한다.

### LottoNumber
* 로또 번호를 가진다.
* 1-45 사이의 번호를 가진다.

### LottoNumbers
* 로또 번호들을 가진다.
* 로또 번호들을 정렬한다.

### PurchaseAmount
* 구매 금액을 가진다.
* 구매한 로또 갯수를 반환한다.

### LottoQuantity
* 발급한 로또 갯수를 가진다.

### LottoTicket
* 생성한 로또 번호들 리스트를 가진다.

### LottoGenerator
* 로또 번호 생성 인터페이스를 가진다.

### AutoLottoGenerator
* LottoGenerator를 상속 받는다.
* 생성할 로또번호의 수는 6개 이다.
* 자동으로 로또 번호를 생성한다.
  * 중복되지 않도록 생성한다.

## 4단계 로또(2등)

### 기능 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

### 기능 목록
* 보너스 볼 입력을 받는다.
* 5개의 번호가 일치할 경우 보너스 볼을 매칭한다.