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