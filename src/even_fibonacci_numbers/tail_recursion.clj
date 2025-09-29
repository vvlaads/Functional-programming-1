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
