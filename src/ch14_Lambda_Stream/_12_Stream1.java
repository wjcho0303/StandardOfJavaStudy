package ch14_Lambda_Stream;

//
//      Stream 이란? 다양한 데이터 소스를 표준화된 방법으로 다루기 위한 것이다.
//      여기서 말하는 "다양한 데이터 소스" 라는 건 Collection, 배열, Map 같이 여러 데이터를 갖고 있는 것들을 말한다.
//      근데 "표준화된 방법으로 다루기 위한 것" 이라는 부분에서는 이미 컬렉션 프레임워크가 달성한 것 아닌가?
//      완전히 성공은 아니다. List 와 Set 은 Collection 인터페이스에 들어가지만 Map 은 별도의 인터페이스인 것부터
//      완전한 성공이라고 볼 수 없다.
//      그래서 이 두 방법들은 사용법이 많이 달랐다. 그러다가 JDK 1.8 부터 Stream 이 나와서
//      이제 정말로 표준화를 이루었다고 할 수 있게 되었다.
//
//      실제로, List, Set, Map 이런 다양한 데이터 소스로부터 Stream 을 만들 수 있다.
//      일단 Stream 을 만들고 나면 통일된 방식으로 작업을 처리할 수 있게 된다.
//      우리는 그 방식을 배우면 된다.
//
//      그 통일된 작업은 크게 "중간연산"과 "최종연산"으로 나눌 수 있다.
//      중간연산은 여러 번 할 수 있는데, 최종연산은 딱 한 번만 한다.
//      그리고 최종연산을 통해 우리가 원하는 결과를 얻게 된다.
//
//
//      그럼 데이터 소스를 이용하여 Stream 을 생성하는 방법을 알아보자:
//      먼저, 데이터 소스가 이렇게 있다고 하자:
//      List<Integer> list = Arrays.asList(1,2,3,4,5);
//
//      이 list 에 대한 Stream 을 생성하는 방법은 다음과 같다:
//      Stream<Integer> intStream = list.stream();
//
//
//      기존에 데이터 소스가 없는 경우에도 Stream 을 생성할 수 있다. 나중에 다시 자세히 설명할 예정.
//      Stream<String> strStream = Stream.of(new String[]{"a","b","c"});    // 문자배열의 스트림
//
//      Stream<Integer> evenStream = Stream.iterate(0, n -> n + 2);     // 짝수의 스트림
//
//      Stream<Double> randomStream = Stream.generate(Math::random);    // 메서드 참조를 이용한 난수의 스트림
//
//      IntStream intStream = new Random().ints(5); // 크기가 5인 난수의 스트림
//
//
//      Stream 을 이용한 작업의 패턴
//      1. Stream 만들기
//      2. 중간연산 (0번 ~ n번)
//      3. 최종연산
//
//
//      Stream 은 시냇물을 의미하는데, 데이터 소스들이 마치 물이 흐르듯이 생성되고 중간연산을 거쳐 최종연산을 거친 후
//      결과물이 하나씩 하나씩 전달된다는 점에서 Stream 이란 이름이 붙은 것이다.
//
//
//
//      Stream 이 제공하는 기능인 중간연산과 최종연산의 특징을 말해보자면,
//      중간연산은 연산결과가 스트림이다.
//      최종연산은 연산결과가 스트림이 아니라 연산이다. 즉, 스트림의 요소를 소모하는 것이다.
//
//      stream.distinct().limit(5).sorted().forEach(System.out::println)
//
//      이런 식으로 되어 있다. 중간연산이 3개이고, 최종연산으로 forEach 문이 보인다.
//      나중에 자세히 얘기하겠지만 간단히 설명하자면, 다양한 중간연산과 최종연산이 있지만,
//      distinct 는 중복제거 limit(5) 은 5개 자르기, sorted 는 정렬이다.
//      forEach 는 최종연산에 자주 사용되는 메서드로, 연산을 거친 요소들을 하나씩 출력한다.
//
//
//      스트림의 특징은 무엇이 있을까?
//      1. Stream 은 데이터 소스 원본을 건드리지는 않고 그냥 데이터를 읽기만 한다.
//      원본을 복사해서 그 복사본을 건드리기는 해도 원본 자체는 데이터의 숫자도, 데이터의 내용도, 순서도 모두 보존된다.
//
//      2. Stream 도 Iterator 처럼 1회용이다. 즉, 필요하면 Stream 을 다시 생성해야 한다.
//      즉, 최종연산을 하고 나면 Stream 의 요소들이 모두 소모되어 Stream 이 닫힌다. 재사용이 안 된다.
//
//      3. Stream 은 최종연산 전까지 중간연산이 수행되지 않는다. 즉, 지연된 연산을 한다.
//      예를 들어 보자.
//      IntStream intStream = new Random().ints(1,46); // 1 ~ 45 범위의 무한 스트림
//      intStream.distinct().limit(6).sorted().forEach(i->System.out.println(i+","));
//
//      위 코드는 로또 번호를 출력하는 코드이다. 근데 문제는 위에 있는 무한 스트림이다. 무한 스트림인데 중복을 제거할 수 있을까?
//      안 될 것 같다. 그러나 이 세계에선 가능하다. 왜냐하면 지연된 연산을 하기 때문에 그렇다.
//      일단 그렇게만 알고 있자. 자세한 건 후에 배우게 된다. 중요한 건 스트림은 "지연된 연산"을 한다는 것이다.
//
//      4. Stream 은 작업을 내부 반복으로 처리한다.
//      forEach 최종연산을 생각하면 쉽게 이해 된다. 굳이 반복문을 입력해주지 않아도
//      forEach 문에 람다식 또는 메서드 참조식을 적어주기만 하면 반복이 알아서 된다.
//      실제로 forEach 문 API 를 보면 반복문을 구현해놓았다. 우린 그냥 편하게 갖다 쓰면 된다.
//
//      5. Stream 은 작업을 병렬로 처리할 수 있다.
//      parallel() 메서드를 이용하면 스트림이 병렬 스트림이 되어 작업을 멀티 쓰레드처럼 병렬로 처리하게 된다.
//      그 반대는 sequential() 메서드이고, 기본이 sequential(직렬)이다.
//
//      6. 기본형 스트림이 있다 : IntStream   LongStream   DoubleStream 등
//      Stream<Integer> 이렇게 쓰는 것보다 IntStream 이렇게 쓰는 게 훨씬 편하다. 그래서 저렇게 쓰면 되고,
//      그리고 숫자와 관련된 유용한 메서드들도 Stream<T> 보다 많이 제공해주기 때문에 좋다.
//      애초부터 지네릭스에 넣은 <T> 이런 것들은 기본형이 아니라 참조형이었다.
//      ★그리고 이렇게 기본형 스트림을 사용하면 auto-boxing 이나 unboxing 과정도 필요가 없어서 성능적으로도 좋다.
//
//      항상 쓸 수 있는 건 아니고, 데이터 소스가 기본형일 때 사용 가능하다.
//      그게 아니면 Stream<Integer> 이런 식으로 써도 되긴 하다.
//


public class _12_Stream1 {
}
