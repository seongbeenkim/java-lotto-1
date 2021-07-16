# java-lotto 게임

### 구입 금액만큼의 로또를 구입하고 해당 로또들의 당첨 통계를 반환해주는 프로그램

### 구현할 기능 목록

- [x] 입력
    - [x] 구매 금액
    - [x] 당첨 번호 
    - [x] 보너스 볼
    
- [x] 출력
    - [x] 구입한 로또 티켓 장수
        - [x] 각 로또 티켓의 번호
    - [x] 당첨 통계
        - [x] 3 ~ 6(보너스 포함)개 일치하는 로또 티켓 장수 
        - [x] 총 수익률
        
- [x] 로또 구입 금액
    - [x] ERROR : 1,000원 미만일 경우
    - [x] ERROR : 1,000원 단위가 아닐 경우
    - [x] 구입할 수 있는 티켓 장수 반환
    
- [x] 티켓 장수
    - [x] ERROR : 티켓 장수가 1장 미만일 경우
    
- [x] 하나의 로또 번호
    - [x] ERROR : 1 ~ 45가 아닐 경우
    - [x] 45개의 번호 캐싱
    - [x] 여러 개의 숫자를 받아 로또 번호 목록을 반환하는 기능
    
- [x] 로또 티켓 한 장
    - [x] ERROR : 서로 다른 6개의 번호를 가지지 않을 경우
    - [x] 로또 티켓의 로또 번호와 당첨 번호를 비교하는 기능 
    
- [x] 모든 로또 티켓
    - [x] 당첨번호와 각 로또 티켓의 번호를 비교하여, 보너스 번호 제외하고 3개 이상 일치하는 결과들을 반환하는 기능
    
- [x] 당첨 번호와 로또 티켓 한 장의 비교 결과
    - [x] 당첨 번호와 일치하는 번호 갯수를 반환하는 기능
    - [x] 보너스 번호 포함 여부 반환하는 기능
    
- [x] 로또 티켓 생성기
    - [x] 자동으로 로또 티켓 생성하는 기능 

- [x] 당첨 번호
    - [x] ERROR : 보너스 볼 포함 서로 다른 7개의 번호를 가지지 않을 경우

- [x] 당첨 등수
    - [x] 로또 비교 결과 객체에 해당하는 로또 등수를 반환하는 기능
    - [x] 등수에 맞는 상금을 반환하는 기능

- [x] 당첨 통계
    - [x] 등수별 개수를 세는 기능
    - [x] 총 수익률을 계산하는 기능 
