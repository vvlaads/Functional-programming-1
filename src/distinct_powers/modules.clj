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



