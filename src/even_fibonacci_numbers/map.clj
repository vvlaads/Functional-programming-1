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