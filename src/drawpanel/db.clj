(ns drawpanel.db
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.operators :refer :all]
            [monger.conversion :refer [from-db-object]]
            [drawpanel.logger :as logger]))


(def last-check (atom 0))

(defn update-last-check []
  (reset! last-check (System/currentTimeMillis)))

(defn new-actions []
  (let [lt    (deref last-check)
        conn (mg/connect { :port 27017 })
        db   (mg/get-db conn "drawBoard")
        actions (mc/find-maps db "drawActions" { :createdAt { $gt lt }})]
    (update-last-check)
    actions))