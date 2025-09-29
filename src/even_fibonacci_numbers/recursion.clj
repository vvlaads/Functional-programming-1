(ns even-fibonacci-numbers.recursion)

(defn fibonacci [n]
  (cond
    (< n 0) 0
    (= n 1) 1
    (= n 2) 2
    :else (+ (fibonacci (dec n)) (fibonacci (- n 2)))))

(defn sum-even-fibonacci [n]
  (let [current_number (fibonacci n)]
    (cond (> current_number 4000000) 0
          (even? current_number) (+ current_number (sum-even-fibonacci (inc n)))
          :else (sum-even-fibonacci (inc n)))))