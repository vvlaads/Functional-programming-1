(ns distinct-powers.recursion)

(defn pow [a b]
  (.pow (biginteger a) b))

(defn count-distinct-terms [a terms]
  (if (> a 100)
    (count terms)
    (count-distinct-terms (inc a)
                          (letfn [(step [b terms]
                                    (if (> b 100)
                                      terms
                                      (step (inc b) (conj terms (pow a b)))))]
                            (step 2 terms)))))

