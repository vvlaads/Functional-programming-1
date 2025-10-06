(ns distinct-powers.inf-list-test
  (:require [clojure.test :refer [deftest is testing]]
            [distinct-powers.inf-list :refer [count-distinct-terms]]))

(deftest count-distinct-terms-test
  (testing
   (is (= 9183 (count-distinct-terms)))))