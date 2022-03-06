# Template Engine

##### **정의** 

템플릿 양식과 특정 데이터 모델에 따른 입력 자료를 합성하여 결과 문서를 출력하는 시스템(소프트웨어)


##### **필요 배경**

**기존 방식**
> 서버에서 DB의 데이터를 가져온 뒤 HTML 로 만들어 클라이언트에게 보내주었다.
> 문제점 : 페이지 일부만 변할 떄에도 전체 페이지를 다시 그려야하는 문제가 발생

> 해결 : Ajax 가 나오면서 서버는 요청한 데이터만 주고 Front-end에서 해당 부분만 재가공하여 보여주었다.
> 문제점 : jquery를 사용하여 javascript를 사용하여 HTML에 가공된 데이터를 보여주는데 조금의 실수가 있으면 페이지가 오류가 난다.

> 해결 : 


## Web Template Engine(웹 템플릿 엔진)

**정의 :**  웹 템플릿들과 웹 컨텐츠 정보(content information)을 처리하게 위한 시스템

즉, View code(html)과 data logic code(DB connection)을 