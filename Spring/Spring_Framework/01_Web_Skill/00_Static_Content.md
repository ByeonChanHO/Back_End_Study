# Static_Content(정적 컨텐츠)

파일을 그대로 웹 브라우저에 내리는 방식을 말한다.

## 사용법
+ src/main/resourses/static 에 그대로 파일을 만들어서 원하는 view를 만들 면 된다.
    + 있는 그대로를 전달한다.

## 원리

![1](https://user-images.githubusercontent.com/38696775/158737112-f4acef96-0379-49e7-8877-428d9ec01b9a.png)

+ 웹 브라우저에서 주소를 요청한다
+ Spring boot 내장 톰켓 서버가 요청을 받아드려서 Spring contatiner 을 확인한다.
    + Contatiner 가 주소에 있는 주소이름 관련 Controller가 있는 지 확인하는 것이다.
        + Spring은 MVC 기반이기에 Controller가 제어권을 가짐으로 Controller부터 체크한다.
+그 후 resources 폴더에 있는 static 파일을 확인하고 서버에 줌으로서 웹 브라우저에 띄운다.

**참고로 간단한 설명입니다. 자세하게는 다르다고 하네요**

## 참조
https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard