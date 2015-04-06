(ns exam-countdown.db
  (:require
      [schema.core :as s]))


;; -- Prismatic Schema  -------------------------------------------------------
;; As exactly as possible, describe the correct shape of app-db.
;; Add a lot of helpful comments. This will be an important resource
;; for anyone looking at the app for the first time.
(def schema
  {})


(defn valid-schema?
  "validate given db, writing any problems to console.error"
  [db]
  (let [res (s/check schema db)]
    (if (some? res)
      (.error js/console (str "schema problem: " res)))))


;; -- Default Value  ----------------------------------------------------------
;; The initial value loaded into app-dp
;;
(def default-value
  {:name "Julia"
   :ecs637u {:name "Digital Media and Social Networks"
             :date "28/04/2015"
             :time "14:30"
             :venue "STOWNHALL"}
   :ecs607u {:name "Data Mining"
             :date "01/05/2015"
             :time "14:30"
             :venue "LAW SUITE"}
   })
