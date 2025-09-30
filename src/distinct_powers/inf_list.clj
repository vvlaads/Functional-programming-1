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