(ns distinct-powers.tail-recursion)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms [a terms]
  (if (> a 100)
    (count terms)
    (recur (inc a)
           (letfn [(step [b terms]
                     (if (> b 100)
                       terms
                       (recur (inc b) (conj terms (pow a b)))))]
             (step 2 terms)))))