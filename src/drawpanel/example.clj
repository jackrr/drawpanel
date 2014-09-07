(ns drawpanel.example
  (:gen-class))

(def p1 [10 10])
(def p2 [200 200])
(def p3 [300 200])
(def p4 [300 248])

(def sample-path [p1 p2 p3 p4])
(def sample-path2 [p1 p3 p2 p4])

(def sample-action {
  :color "#000000"
  :weight 5
  :user 0
  :path sample-path })

(def sample-action2 {
  :color "#005000"
  :weight 5
  :user 0
  :path sample-path2 })

(def actions [ sample-action sample-action2 ])