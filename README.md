# Лабораторная работа №1

  * Студент: `Силинцев Владислав Витальевич`
  * Группа: `P3314`
  * ИСУ: `355273`
  * Функциональный язык: `Clojure`
---

## Проблема 2 (Even Fibonacci Numbers)
### Описание
Каждое новое слагаемое в последовательности Фибоначчи генерируется путем сложения двух предыдущих слагаемых. Если начать с $1$ и $2$, то первые $10$ слагаемых будут:

$$1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...$$

Рассматривая слагаемые в последовательности Фибоначчи, значения которых не превышают четырех миллионов, найдите сумму четных слагаемых.

### Решение через рекурсию
**Ключевые элементы реализации:** 
* Простая рекурсивная функция `fibonacci`
* Рекурсивное суммирование четных чисел, которые не превышают 4000000

```clojure
(ns even-fibonacci-numbers.recursion)

(defn fibonacci [n]
  (cond
    (< n 0) 0
    (= n 1) 1
    (= n 2) 2
    :else (+ (fibonacci (dec n)) (fibonacci (- n 2)))))

(defn sum-even-fibonacci [n]
  (let [current-number (fibonacci n)]
    (cond (> current-number 4000000) 0
          (even? current-number) (+ current-number (sum-even-fibonacci (inc n)))
          :else (sum-even-fibonacci (inc n)))))
```

### Решение через хвостовую рекурсию
**Ключевые элементы реализации:** 
* `loop/recur` для хвостовой рекурсии у функции `fibonacci`
* Вызов `recur` в конце основной функции `sum-even-fibonacci` для обеспечения хвостовой рекурсии

```clojure
(ns even-fibonacci-numbers.tail-recursion)

(defn fibonacci [n]
  (loop [i 0 a 0 b 1]
    (if (= i n)
      a
      (recur (inc i) b (+ a b)))))

(defn sum-even-fibonacci [n result]
  (let [current-number (fibonacci n)]
    (if (>= current-number 4000000)
      result
      (recur (inc n)
             (if (even? current-number)
               (+ result current-number)
               result)))))

```

### Решение через модульную реализацию
**Ключевые элементы реализации:** 
* Разбиение задачи на функции `generate-fibonacci`, `even-numbers`, `sum-numbers`
* Последовательная фильтрация и суммирование
* Использование `letfn` для локальной рекурсии.

```clojure
(ns even-fibonacci-numbers.modules)

(defn generate-fibonacci [limit]
  (letfn [(step [a b seq]
            (if (>= a limit)
              seq
              (step b (+ a b) (conj seq a))))]
    (step 1 2 [])))

(defn even-numbers [seq]
  (filter even? seq))

(defn sum-numbers [seq]
  (reduce + seq))

(defn sum-even-fibonacci []
  (sum-numbers (even-numbers (generate-fibonacci 4000000))))
```

### Решение через map
**Ключевые элементы реализации:** 
* Использование функциональных операций `map`, `take-while`, `filter`, `reduce`
* Генерация последовательности через `range` и рекурсивную функцию `fibonacci`.

```clojure
(ns even-fibonacci-numbers.map)

(defn fibonacci [n]
  (cond
    (< n 0) 0
    (= n 1) 1
    (= n 2) 2
    :else (+ (fibonacci (dec n)) (fibonacci (- n 2)))))

(defn sum-even-fibonacci []
  (->> (range 1 35)
       (map fibonacci)
       (take-while #(< % 4000000))
       (filter even?)
       (reduce +)))
```

### Решение через циклы
**Ключевые элементы реализации:** 
* `loop/recur` для пошагового вычисления Фибоначчи
* `result` хранит сумму четных чисел последовательности на текущей итерации

```clojure
(ns even-fibonacci-numbers.loop)

(defn sum-even-fibonacci []
  (loop [a 1 b 2 result 0]
    (if (> a 4000000)
      result
      (recur b (+ a b)
             (if (even? a)
               (+ a result)
               result)))))
```

### Решение через бесконечные списки
**Ключевые элементы реализации:** 
* Ленивый список через `iterate`
* `filter` для отбора только четных чисел
* `take-while` для ограничения последовательности
* Суммирование через `reduce`.

```clojure
(ns even-fibonacci-numbers.inf-list)

(def fibonacci
  (map first (iterate (fn [[a, b]] [b (+ a b)]) [1 2])))

(defn sum-even-fibonacci []
  (reduce + (take-while #(< % 4000000) (filter even? fibonacci))))
```

### Решение на языке Java
**Ключевые элементы реализации:** 
* Рекурсивная функция `fibonacci`
* Проход в цикле `while` с проверкой четности

```java
public class Main {
    public static int fibonacci(int n) {
        if (n < 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int currentNumber = 0;
        int result = 0;
        int n = 0;

        while (currentNumber <= 4_000_000) {
            currentNumber = fibonacci(n);
            if (currentNumber % 2 == 0) {
                result += currentNumber;
            }
            n++;
        }

        System.out.println(result);
    }
}
```

## Проблема 29 (Distinct Powers)
### Описание
Рассмотрим все целые комбинации $a^b$ для $2 \le a \le 5$ и $2 \le b \le 5$:

$$
\begin{array}{cccc}
2^2 = 4   & 2^3 = 8   & 2^4 = 16   & 2^5 = 32 \\
3^2 = 9   & 3^3 = 27  & 3^4 = 81   & 3^5 = 243 \\
4^2 = 16  & 4^3 = 64  & 4^4 = 256  & 4^5 = 1024 \\
5^2 = 25  & 5^3 = 125 & 5^4 = 625  & 5^5 = 3125
\end{array}
$$


Если затем расположить их по числовому порядку и удалить все повторения, получаем следующую последовательность из 15 различных чисел:

$$4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125.$$

Сколько различных чисел будет в последовательности, сгенерированной выражением $a^b$ для $2 \le a \le 100$ и $2 \le b \le 100$?

### Решение через рекурсию
**Ключевые элементы реализации:** 
* Рекурсивный обход диапазонов `a` и `b`
* Использование `letfn` для вложенной рекурсии

```clojure
(ns distinct-powers.recursion)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms [a terms]
  (if (> a 100)
    (count terms)
    (count-distinct-terms (inc a)
                          (letfn [(step [b terms]
                                    (if (> b 100)
                                      terms
                                      (step (inc b) (conj terms (pow a b)))))]
                            (step 2 terms)))))
```

### Решение через хвостовую рекурсию
**Ключевые элементы реализации:** 
* `recur` для хвостовой рекурсии

```clojure
(ns distinct-powers.tail-recursion)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms [a terms]
  (if (> a 100)
    (count terms)
    (recur (inc a)
           (letfn [(step [b terms]
                     (if (> b 100)
                       terms
                       (recur (inc b) (conj terms (pow a b)))))]
             (step 2 terms)))))
```

### Решение через модулюную реализацию
**Ключевые элементы реализации:** 
* Раздельные функции `generate-powers` и `unique-powers`
* Построение коллекции степеней через `for`
* Использование `set` для удаления дубликатов

```clojure
(ns distinct-powers.modules)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn generate-powers []
  (for [a (range 2 101)
        b (range 2 101)]
    (pow a b)))

(defn unique-powers [powers]
  (set powers))

(defn count-distinct-terms []
  (count (unique-powers (generate-powers))))
```

### Решение через map
**Ключевые элементы реализации:** 
* `map` и `flatten` для построения коллекций
* `set` для уникальности
* Генерация диапазона через `range`.

```clojure
(ns distinct-powers.map)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms []
  (->> (range 2 101)
       (map (fn [a] (map #(pow a %) (range 2 101))))
       flatten
       set
       count))
```

### Решение через циклы
**Ключевые элементы реализации:** 
* `for` для генерации последовательности
* `set` для хранения уникальных элементов

```clojure
(ns distinct-powers.loop)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms []
  (count (set
          (for [a (range 2 101)
                b (range 2 101)]
            (pow a b)))))
```

### Решение через бесконечные списки
**Ключевые элементы реализации:** 
* Ленивые списки через `iterate`
* Генерация диапазона `b` через `range`
* `map` и `flatten` для построения коллекции
* `set` для уникальности.

```clojure
(ns distinct-powers.inf-list)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms []
  (->> (iterate inc 2)
       (map (fn [a]
              (map #(pow a %) (range 2 101))))
       (take 99)
       flatten
       set
       count))
```

### Решение на языке Java
**Ключевые элементы реализации:** 
* Хранение уникальных значений в `HashSet`
* Два цикла `for` для создания последовательности

```java
package distinct_powers;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<BigInteger> terms = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                terms.add(BigInteger.valueOf(a).pow(b));
            }
        }
        System.out.println(terms.size());
    }

}
```

## Выводы
В ходе выполнения лабораторной работы я познакомился с основами функционального языка `Clojure` и применил его для решения практических задач.

В процессе работы я освоил:
* Рекурсию — как обычную, так и хвостовую, с использованием конструкции `recur` для оптимизации.
* Циклы — через механизм `loop/recur` и форму `for`.
* Работу с функциями — включая вложенные функции `(letfn)` и анонимные функции (`#()`, `(fn [])`).
* Ленивые вычисления — научился создавать бесконечные последовательности с помощью `iterate` и `range`.
* Обработку коллекций — используя функции `map`, `filter`, `take-while`, `flatten` и `reduce`.
* Потоковые макросы — применил макрос `->>` для построения цепочек вычислений, что улучшило читаемость кода.
