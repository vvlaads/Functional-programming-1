(ns distinct-powers.tail-recursion-test
  (:require [clojure.test :refer [deftest is testing]]
            [distinct-powers.tail-recursion :refer [count-distinct-terms]]))

(deftest count-distinct-terms-test
  (testing
   (is (= 9183 (count-distinct-terms 2 #{})))))