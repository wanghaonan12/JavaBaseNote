# Reflect
## 反射的引入
> Java 中的反射机制提供了在运行时动态地获取类的信息和操作类的成员（字段、方法、构造函数等）的能力。反射使得我们可以在编译时不需要知道类的具体信息，而在运行时动态地操作类和对象。

以下是一个案例，说明 Java 中为什么需要反射：

假设我们有一个类 `Person`，它有一些私有字段和方法：

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void sayHello() {
        System.out.println("Hello, I'm " + name);
    }
}
```

现在，假设我们想要通过一个字符串来创建一个 `Person` 对象、访问其私有字段和调用私有方法。如果没有反射机制，我们将无法实现这样的操作。

使用反射，我们可以实现以下操作：

```java
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Code_01_ReflectBringIn {
    public static void main(String[] args) throws Exception {
        // 通过字符串创建 Person 对象
        Class<?> personClass = Class.forName("Person");
        Person person = (Person) personClass.getDeclaredConstructor(String.class, int.class)
                                          .newInstance("Alice", 25);

        // 访问私有字段
        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        int age = (int) ageField.get(person);
        System.out.println("Age: " + age);

        // 调用私有方法
        Method sayHelloMethod = personClass.getDeclaredMethod("sayHello");
        sayHelloMethod.setAccessible(true);
        sayHelloMethod.invoke(person);
    }
}
```

在上述示例中，我们使用反射机制获取了 `Person` 类的信息，并且可以通过字符串动态地创建 `Person` 对象、访问私有字段和调用私有方法。

反射机制的应用场景包括但不限于：
- 动态地创建对象，可以在编译时不确定类的具体类型。
- 动态地操作对象的成员，包括字段的读写和方法的调用。
- 获取类的元数据，如类的注解、接口、父类等。
- 实现框架、库和工具，提供通用的解析和操作能力。

尽管反射机制具有强大的灵活性和动态性，但由于使用反射可能会牺牲一些性能，因此应谨慎使用。在大多数情况下，应优先选择直接访问类的公共接口和成员，只有在必要时才使用反射机制。