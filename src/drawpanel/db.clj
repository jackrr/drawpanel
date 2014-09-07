(ns drawpanel.db
  (:require [monger.core :as mongo]))

(let [conn (mongo/connect { :port 27017 })
      db   (mongo/get-db conn "draw-board")
      coll "draw-actions"])

(defn actions-since [since]
  (mongo/find-maps db coll { :createdAt { "$gt" since }}))

