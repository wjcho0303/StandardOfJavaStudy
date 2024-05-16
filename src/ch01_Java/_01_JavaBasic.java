package ch01_Java;
//
//  환경변수 경로를 등록해두면 컴퓨터가 실행 파일을 찾을 때 현 경로에 없으면 환경변수에 등록된 경로들을 우선순위가 높은 것부터
//  차례대로 찾는다. jdk의 bin 디렉토리를 환경변수 경로로 등록해두면 커맨드 창에서 경로명을 입력하지 않아도 파일명만으로도 실행이 가능해진다.
//
//  이렇게 해놓은 후 javac Hello.java 라고 커맨드창에 입력하면 javac.exe (컴파일러)가 Hello.class 라는 파일을 생성한다.
//  이렇게 만들어진 Hello.class 파일이 바로 JVM이 알아들을 수 있는 기계어로 변환된 형태의 파일인 것이다.
//  실제로 Hello.java 파일은 텍스트로 알아들을 수 있게 표시되지만 Hello.class 파일은 JVM이 해석할 수 있는 기계어로 변환된 바이너리 파일 형태이기 때문에 알아볼 수 없다.
//
//  그 상태에서 커맨드에 java Hello 라고 치면
//  Hello, world 라는 출력문이 실제로 실행된다.
//          이렇게, 실행할 때는 프로그램명인 java.exe와 Hello.class 이름을 입력하고, 뒤에 확장자명은 붙이지 않는다.
//  그렇게 해서 java Hello 라는 명령문을 입력했을 때 Hello.class 가 실행되는 것이다.
//
//  만약 Hello.java 파일에 에러가 존재한다면 javac Hello.java 라고 했을 때 컴파일 에러가 발생하고, 관련 에러 정보를 나타내준다.
//  인텔리제이는 이것을 바로바로 해주는데 이렇게 콘솔로 수동으로 하면서 컴파일의 원리를 이해해볼 수 있는 것이다.
//
//  javac.exe
//  자바 컴파일러. 사람이 작성한 문장을 기계어로 번역하여 소스 파일인 .java 파일을 .class 파일로 변환하여 생성한다.
//  이러한 class 파일 생성을 자바에서 build라고 부른다.
//  스프링 부트의 의존성 라이브러리 build 하는 것과는 다른 개념이니 헷갈리지 않도록 하자.
//  이클립스와 인텔리제이는 이를 자동으로 처리해준다.
//
//  java.exe
//  자바 인터프리터. 자바 프로그램으로, 클래스파일(.class)을 실행한다.
//
//  class
//  자바 프로그램의 단위. 자바 프로그램은 class들로 구성되어 있다.
//  모든 문장은 클래스의 중괄호 { } 안에 있어야 한다.
//
//  main 메서드
//  자바 프로그램의 시작점. 이 메서드 없이 프로그램 실행 불가.
//



public class _01_JavaBasic {
}
