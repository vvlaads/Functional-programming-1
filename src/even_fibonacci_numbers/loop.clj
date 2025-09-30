(ns even-fibonacci-numbers.loop)

(defn sum-even-fibonacci []
  (loop [a 1 b 2 result 0]
    (if (> a 4000000)
      result
      (recur b (+ a b)
             (if (even? a)
               (+ a result)
               result)))))