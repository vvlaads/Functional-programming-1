(ns lab1.core-test
  (:require [clojure.test :refer [deftest is]]
            [lab1.core :refer [phrase]]))

(deftest phrase-test
  (is (= "Hero: This is my first battle" (phrase "This is my first battle"))))
