(ns even-fibonacci-numbers.tail-recursion-test
  (:require [clojure.test :refer [deftest is testing]]
            [even-fibonacci-numbers.tail-recursion :refer [sum-even-fibonacci]]))

(deftest sum-even-fibonacci-test
  (testing
   (is (= 4613732 (sum-even-fibonacci 1 0)))))