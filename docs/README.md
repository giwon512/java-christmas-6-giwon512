# 4주차 미션 - 크리스마스 프로모션

12월 식당의 할인 이벤트가 적용된 내역을 보여줌으로써 손님이 혜택을 체감할 수 있게 하는 프로그램을 작성해야한다.

## 구현할 기능 목록

- [o] 입력, 출력 클래스 만들기
- [o] 메뉴 정보를 관리하는 enum 클래스 만들기
- [o] 이벤트 뱃지 정보를 관리하는 enum 클래스 만들기
- [o] 방문 날짜와 주문 내용을 다룰 order 클래스 만들기
- 입력 받기
    - [o] 방문 날짜 입력 받기
    - [o] 주문할 메뉴와 개수 입력 받기
- [o] 혜택 내역 관리를 위한 benefits 클래스 만들기
- [o] 혜택 내역 출력하기
- [o] 숫자 3자리마다 콤마 출력하도록 구현
- 테스트코드 작성하기
    - [o] string 클래스 함수 동작 확인하기
    - [o] order 클래스 함수 동작 확인하기
    - [o] benefits 클래스 함수 동작 확인하기

## trouble shooting
프로그램에서 자주 다루는 메뉴와 같은 상수를 효과적으로 다루기 위해서 enum 클래스를 처음으로 사용해 보았다. 
주문한 메뉴 정보를 관리하기 위해 map 자료구조에 담아서 활용했는데, 각 원소를 순회하는 과정에서 어려움을 겪었지만
이외에는 순탄하게 해결해내었다.