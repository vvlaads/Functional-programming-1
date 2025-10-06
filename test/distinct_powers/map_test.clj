(ns distinct-powers.map-test
  (:require [clojure.test :refer [deftest is testing]]
            [distinct-powers.map :refer [count-distinct-terms]]))

(deftest count-distinct-terms-test
  (testing
   (is (= 9183 (count-distinct-terms)))))