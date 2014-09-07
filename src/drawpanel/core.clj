(ns drawpanel.core
  (:gen-class)
  (:require [quil.core :as q])
  (:require [drawpanel.example :as examples]))

(defn log [obj]
  (println (str obj)))

(defn setup []
  (q/smooth)
  (q/background 255)
  (q/frame-rate 1))

(defn draw-line [p1 p2 color weight]
  (q/stroke color)
  (q/stroke-weight weight)
  (q/line p1 p2))

(defn draw-action [action]
  (draw-line (get (:path action) 0) (get (:path action) 1) (q/unhex (:color action)) (:weight action)))

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