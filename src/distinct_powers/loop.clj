(ns distinct-powers.loop)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms []
  (count (set
          (for [a (range 2 101)
                b (range 2 101)]
            (pow a b)))))