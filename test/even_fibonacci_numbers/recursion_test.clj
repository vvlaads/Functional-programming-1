(ns even-fibonacci-numbers.recursion-test
  (:require [clojure.test :refer [deftest is testing]]
            [even-fibonacci-numbers.recursion :refer [sum-even-fibonacci]]))

(deftest sum-even-fibonacci-test
  (testing
   (is (= 4613732 (sum-even-fibonacci 1)))))