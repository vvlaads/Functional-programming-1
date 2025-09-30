(ns distinct-powers.map)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms []
  (->> (range 2 101)
       (map (fn [a] (map #(pow a %) (range 2 101))))
       flatten
       set
       count))