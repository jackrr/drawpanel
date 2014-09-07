(ns drawpanel.core
  (:gen-class)
  (:require [quil.core :as q])
  (:require [drawpanel.example :as examples])
  (:require [clojure.string :as string]))

(defn log [obj]
  (println (str obj)))

(defn setup []
  (q/smooth)
  (q/background 255)
  (q/frame-rate 1))

(defn p2p [p1 p2]
  (if (vector? p2) (q/line p1 p2)))

(defn draw-line [points color weight]
  (q/stroke color)
  (q/stroke-weight weight)
  (let [nums (map vector (iterate inc 0) points)]
    (doseq [[idx value] nums] (p2p value (get points (inc idx))))))

(defn safe-color [hex]
  (q/unhex (string/replace hex "#" "")))

(defn draw-action [action]
  (draw-line (:path action) (safe-color (:color action)) (:weight action)))

(defn check-for-new-actions []
  (log "Loading next actions")
  (draw-action examples/sample-action))


(defn -main [& args]
  (println "Started up")
  (q/defsketch display
    :title "Display"
    :setup setup
    :draw check-for-new-actions
    ; :size [(q/screen-width) (q/screen-height)]))
    :size [500 500]))