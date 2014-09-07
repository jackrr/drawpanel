(ns drawpanel.example
  (:gen-class))

(def p1 [10 10])
(def p2 [200 200])
(def p3 [300 200])

(def sample-path [p1 p2 p3])

(def sample-action {
  :color "000000"
  :weight 5
  :user 0
  :path sample-path })