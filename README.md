# cleanCode
clean code 를 지향하는 project


# 대원칙

객체지향 생활체조 원칙을 준수한다.

- 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기(indent)만 한다.
- 규칙 2: else 예약어를 쓰지 않는다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 4: 한 줄에 점을 하나만 찍는다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 규칙 6: 모든 엔티티를 작게 유지한다.
- 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 규칙 8: 일급 콜렉션을 쓴다.
- 규칙 9: 게터/세터/프로퍼티를 쓰지 않는다.

# 실적용

- 과도한 들여쓰기는 가독성을 저하시킨다. (co-op 시 유의)
- 한 줄에 한점만 사용 시 코드가 너무 방대해지는 단점, 오히려 가독성을 떨어뜨린다.
  - 하나의 로직을 수행 할 경우 1점을 지키지 않는게 좋을 수 있다.
    - checkString.stream.filter(check -> StringUtils.hasText(check)).collections(Collectors.toList())
    - checkString.stream
        .filter(
          check -> StringUtils.hasText(check))
        .collections(Collectors.toList())
        이 경우 보단
    - checkString.stream                              // object wrapping
        .filter(check -> StringUtils.hasText(check))  // check 로직이며, 조건은 이렇다를 한줄에 기입
        .collections(Collectors.toList())             // 결과를 return
