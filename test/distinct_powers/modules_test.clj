(ns distinct-powers.modules-test
  (:require [clojure.test :refer [deftest is testing]]
            [distinct-powers.modules :refer [count-distinct-terms]]))

(deftest count-distinct-terms-test
  (testing
   (is (= 9183 (count-distinct-terms)))))