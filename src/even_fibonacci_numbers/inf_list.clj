(ns even-fibonacci-numbers.inf-list)

(def fibonacci
  (map first (iterate (fn [[a, b]] [b (+ a b)]) [1 2])))

(defn sum-even-fibonacci []
  (reduce + (take-while #(< % 4000000) (filter even? fibonacci))))