# MVC 와 Template Engine(템플릿 엔진)

Spring MVC는 MVC 패턴 기반의 웹 프레임워크

+ **MVC(Model, View, Controller)**
    + **Model**
        + 애플리케이션 정보, 데이터를 관리한다.
    + **View**
        + 사용자 인터페이스(화면)
    + **Controller**
        + Model과 View 간 상호 동작 조정

## Spring MVC Component(구성요소)
1. **DispatcherServlet**
    + 클라이언트의 요청을 전달 받아 요청에 맞는 컨트롤러가 리턴한 결과 값을 View에 전달하여 알맞은 응답을 생성
    + (모든 연결을 담당한다고 생각하면 된다.)

2. **HandlerMapping**
    + Client의 요청 URL을 어떤 Controller가 처리할 지 결정

3. **Controller**
    + Client의 요청을 처리한 뒤, 결과를 DispatcherServlet에게 리턴

4. **ModelAndView**
    +