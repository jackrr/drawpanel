(ns drawpanel.db
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [drawpanel.logger :as logger]))


(def last-check (atom 0))

(defn update-last-check []
  (reset! last-check (quot (System/currentTimeMillis) 1000)))

(defn new-actions []
  (let [t    (deref last-check)
        conn (mg/connect { :port 27017 })
        db   (mg/get-db conn "draw-board")
        actions (mc/find-maps db "draw-actions")]
    (update-last-check)
    (logger/log actions)
    actions))
    ; (mc/find-maps db coll { :createdAt { "$gt" t }})))