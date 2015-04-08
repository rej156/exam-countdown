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
  {:exams [{:title "Digital Media"
            :timestamp 201504281430
            :date "28/04/2015"
            :month 04
            :day 28
            :time "14:30"
            :venue "STOWNHALL"}
           {:title "C++ for Image Processing"
            :timestamp 201505011430
            :date "01/05/2015"
            :month 05
            :day 01
            :time "14:30"
            :venue "LAW SUITE"}
           {:title "Data Mining"
            :timestamp 201508011430
            :date "01/08/2015"
            :month 05
            :day 04
            :time "14:30"
            :venue "LAW SUITE"}
           ]
   :selected-exams ["Digital Media"]})
