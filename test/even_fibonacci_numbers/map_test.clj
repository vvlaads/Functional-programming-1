(ns even-fibonacci-numbers.map-test
  (:require [clojure.test :refer [deftest is testing]]
            [even-fibonacci-numbers.map :refer [sum-even-fibonacci]]))

(deftest sum-even-fibonacci-test
  (testing
   (is (= 4613732 (sum-even-fibonacci)))))