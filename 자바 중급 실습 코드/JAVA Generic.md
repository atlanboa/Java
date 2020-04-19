# JAVA - Generic

Created: Apr 19, 2020 12:14 PM
Created By: 상헌 김
Last Edited By: 상헌 김
Last Edited Time: Apr 19, 2020 4:42 PM

### 제네릭(Generic) 이란?

- 타입을 파라미터화해서 컴파일시 구체적인 타입이 결정되도록 하는 것
- Doc 를 쉽게 읽기 위해서는 꼭 알아야 한다.

### 제네릭을 사용해서 얻는 이점은?

- **컴파일시 강한 타입 체크를 할 수 있다.**

    > 실행시 에러 발생이 나는 것보다, 컴파일시 타입을 체크하여 에러를 사전에 방지

- **타입 변환을 제거할 수 있다. 직접적으로 와닿지 않기 때문에 코드로 확인해보자.**

        1. List에서 객체를 얻어서 사용하는 과정을 보자.
        
        List list = new ArrayList();
        list.add("hello");
        String str = (String) list.get(0);
        
        새로운 list를 선언하여 String "hello"를 추가하고 list에서 추가된 
        String을 반환받는다. 반환할 시에 형변환이 필요하다. 형 변환을 하지
        않으면 아마도 컴파일 에러가 발생할 것이다.
        

    ![JAVA%20Generic/Untitled.png](JAVA%20Generic/Untitled.png)

        위와 같이 형변환이 없어서 컴파일 에러가 발생한다.
        그 이유는 아래와 같다.
        타입을 지정해주지 않은 list의 get method는 Object 타입을 반환한다
        그러기에 형변환이 필요하다 하지만 애초에 List를 생성할 때 generic을
        String으로 지정한다면 형변환이 필요없을 것이다.
        
        아래를 보자
        아래와 같은 이유로 제네릭은 유용하게 사용된다.

    ![JAVA%20Generic/Untitled%201.png](JAVA%20Generic/Untitled%201.png)

    에러가 발생하지 않는 경우

### 제네릭 타입이란?

- 타입을 파라미터로 가지는 클래스와 인터페이스
- < , > 사이에 타입 파라미터가 위치
- 일반적으로 대문자 알파벳 한문자로 표현한다.
- 개발 코드에서는 타입 파라미터 자리에 구체적인 타입을 지정해야 한다.

    public class 클래스명<T> {...}
    public interface 인터페이스명<T> {...}

***제니릭 타입을 사용할 경우?***

    public class Box {
    	private Object object;
    	public void set(Object object) { this.object = object }
    	public Object get() { return object }
    }

위의 클래스는 모든 객체를 담을 수 있는 Box 클래스다. 모든 객체의 최상위 객체는 Object 이므로 Java에서 생성되는 존재하는 모든 클래스는 Object에 대입이 될 수 있다.

하지만 이 부분은 심각한 성능 문제가 발생한다. 코드를 확인하자

    Box box = new Box();
    box.set("hello");
    String str = (String) box.get();

위 코드에서 발생하는 형변환은 2번이다.

`box.set("hello")` 에서 String에서 Object 타입으로 형 변환

`String str = (String) box.get()` 에서 Object 타입을 String으로 형 변환

물론 이런 코드를 작성하게 된다면 다양한 객체를 담을 수 있는 class를 생성할 수 있다. 하지만 실무에서 이런 코드를 필요하게 되는 경우는 거의 없다고 한다. 따라서 굳이 매번 형변환을 해줘야 하는 위와 같은 코드보다는 Generic 사용을 권장한다.

기존의 Box class를 제네릭을 활용하여 변경해보자

    public class Box<T> {
    	private T t;
    	public T get() { return t; }
    	public void set(T t) { this.t = t; }
    }

위 코드를 실질적으로 사용할 때는 제네릭의 구체적인 타입을 지정해야 한다.

아래 코드를 확인하자

    Box<String> box = new Box<String>();
    이런 식으로 사용하게 된다면 위의 Box class에서 T는 String으로 변경되어
    아래와 같은 형식으로 사용되게 된다.
    public class Box<String> {
    	private String t;
    	public void set(String t) { this.t = t;}
    	public String get() { return t; }
    }
    
    만약에 T에 구체적인 타입을 지정하지 않는다면?
    T는 Object 타입으로 지정된다.

### 멀티 타입 파라미터

두 개 이상의 타입 파라미터를 사용해서 선언할 수 있음

`class <K, V, ...> { ... }`

`interface <K, V, ...> { ... }`

    public class Product<T, M> {
    	private T kind;
    	private M model;
    
    	public T getKind() { return this.kind; }
    	public M getModel() { return this.model; }
    	
    	public void setKind(T kind) { this.kind = kind;}
    	public void setModel(M model) { this.model = model; }
    }

위와 같이 두 개 이상의 타입 파라미터를 사용해서 정의하면 된다.

자바 7부터는 중복된 타입 파라미터를 선언하는 과정에서 번거로운 과정이 생략될 수 있도록 <> 연산자가 제공된다.

    기존 
    Product<Tv, String> product = new Product<Tv, String>();
    
    자바 7 이후
    Product<Tv, String> product = new Product();

타입 파라미터에 지정되는 알파벳은 어떠한 알파벳을 사용해도 무관하다.

하지만 의미를 부여해서 이해할 수 있는 알파벳을 쓰는게 코드의 가독성을 높히는데 도움을 주지 않을까 생각한다.

### 제네릭 메소드

매개변수 타입과 리턴 타입으로 타입 파라미터를 갖는 메소드

**제네릭 메소드 선언 방법은 아래와 같다.**

`public <타입 파라미트> 리턴타입 메소드명(매개변수...) {...}`

`public <T> Box<T> boxing(T t) {...}`

**제네릭 메소드를 호출하는 방법은 아래와 같다.**

    1. 리턴타입 변수 = <구체적타입> 메소드명(매개값);
    2. 리턴타입 변수 = 메소드명(매개값);

일반적으로 2번 방식을 많이 사용한다.

1번은 명시적으로 지정하고, 2번은 추정되는 방식으로 사용된다.

제네릭 메소드를 가지는 Util 클래스를 만들어주겠다.

    public class Util {
        public static <T> Box<T> boxing(T t) {
            Box<T> box = new Box<T>();
            box.set(t);
            return box;
        }
    }

이 Util 클래스의 boxing을 사용해보겠다.

    
    public class genericMethodExample {
        public static void main(String[] args) {
            // 1번 방식 : 명시적 호출
            Box<Integer> box1 = Util.<Integer>boxing(100);
            // 2번 방식 : 유추하는 호출
            Box<String> box2 = Util.boxing("100!!");
            int box1Value = box1.get();
            String box2Value = box2.get();
            System.out.println(box1Value);
            System.out.println(box2Value);
        }
    }

명시적인 방법과 컴파일러가 유추해서 타입을 지정하는 방식을 모두 사용해보았다.

**좀 더 제네릭 메소드를 심화해서 사용하보자.**

두 개의 객체의 키값을 비교하여 같은지 다른지 리턴하는 메소드를 구현해보자

    public class CompareMethodExample {
        public static void main(String[] args) {
            Pair<Integer, String> p1 = new Pair<>(1, "사과");
            Pair<Integer, String> p2 = new Pair<>(1, "사과");
    
            boolean comp = Util.<Integer, String>compare(p1, p2);
            System.out.println(comp? "same" : "diff");
            comp = Util.compare(p1, p2);
            System.out.println(comp? "same" : "diff");
        }
    }

    package app;
    
    public class Pair <K, V> {
        private K key;
        private V value;
    
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() {
            return this.key;
        }
    
        public void setKey(K key) {
            this.key = key;
        }
    
        public V getValue() {
            return this.value;
        }
    
        public void setValue(V value) {
            this.value = value;
        }
        
    }

    public class Util {
        public static <T> Box<T> boxing(T t) {
            Box<T> box = new Box<T>();
            box.set(t);
            return box;
        }
    
        public static <K,V> Boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
            boolean keyCompare = p1.getKey().equals(p2.getKey());
            boolean valueCompare = p1.getValue().equals(p2.getValue());
            return keyCompare && valueCompare;
        }
    }

### 제한된 타입 파라미터

제네릭 타입을 사용하여 특정 클래스만 올 수 있도록 제한할 수 있다.

만약 특정 파라미터에 구체적인 타입을 제한할 필요가 있는 경우 사용한다.

`public <T extends 상위타입> 리턴타입 메소드(매개변수, ...) {...}` 

- 상위 타입은 클래스 뿐만 아니라 인터페이스도 가능하다. 하지만 인터페이스라고 해서 extends 대신 implements를 사용하지 않는다. 왜 implements를 사용하지 않는가는? 인터페이스의 구현 클래스가 올 수 있다는 말이기 때문이다.

**주의할 점**

- 메소드의 중괄호 {} 안에서 타입 파라미터 변수로 사용 가능한 것은 상위 타입의 멤버(필드, 메소드)로 제한된다.
- 하위 타입에만 있는 필드와 메소드는 사용할 수 없다.

    public <T extends Number> int compare(T t1, T t2) {
    	double v1 = t1.doubleValue();
    	double v2 = t2.doubleValue();
    	return Double.compare(v1, v2);
    }

위 코드를 보면 Number의 상위 타입 혹은 하위 타입으로 타입이 제한된다. 

하지만 여기서 사용되는 doubleValue()를 호출할 수 있는 것은 Number의 상위에 doubleValue라는 메소드가 정의되어 있기때문이다.

만약에 Number 하위 타입을 매개변수로 넘긴다면, Number 하위 클래스에 대한 메소드나 매개변수 호출이 불가능하다.

### 와일드카드 타입

**제네릭 타입을 매개변수나 리턴타입으로 사용할 때 타입 파라미터를 제한할 목적**

- **<T extends 상위 또는 인터페이스> 는 제네릭 타입과 제네릭 메소드를 선언할 때 제한을 한다.**

        public static void registerCourse(Course<?> course) {
        public static void registerCourse(Course<? extends Student> course) {
        public static void registerCourse(Course<? super Worker> course) {

- **와일드 카드의 세가지 형태**
    1. **제네릭 타입 <?> : Unbounded Wildcard (제한없음)**

        타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올 수 있다.

    2. **제네릭타입 <? extends 상위타입> : Upper Bounded Wildcards (상위 클래스 제한)**

        타입 파라미터를 대치하는 구체적인 타입으로 상위 타입이나 하위 타입만 올 수 있다. 

        쉽게 말하면 extends 뒤에 오는 타입이 최상위 클래스가 되야한다. 

        최상위 클래스는 person ← student ← highstudent 의 관계를 가지는 클래슥 존재할 때, person이 최상위 클래스가 되어 자식 클래스만 올 수 있다. 따라서 extends student가 온다면 student가 매개변수로 올 수 있는 최상위 클래스가 되고 person은 매개변수로 올 수 없도록 제한된다.

    3. **제네릭타입 <? super 하위타입> : Lower Bounded Wildcard ( 하위 클래스 제한**

        타입 파라미터를 대치하는 구체적인 타입으로 하위 타입이나 상위 타입이 올 수 있다. 2번과 다르게 최하위타입이 된다. 따라서 올 수 있는 매개변수는 자기 자신과 부모 클래스들이 된다.

    만약에 제네릭 타입으로 결정되는 배열을 생성하고자 할때
    
    public class Course<T> {
    	private String name;
    	private T[] students;
    
    	public Course(String name, int capacity) {
    		this.name = name;
    		// 일반적으로 배열은  = new Type[크기]와 같이 선언한다.
    		// 하지만 제네릭 T배열을 만들려고 하면 에러가 발생한다.
    		// 왜? 아직 T의 타입이 결정이 되지 않았기 때문이다.
    		// 이 부분은 Object 배열을 만들어 형변환으로 해결이 가능하다.
    		this.students = (T[])(new Object[capacity]);
    	}
    }