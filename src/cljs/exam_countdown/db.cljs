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
           {:title "Big Data Processing"
            :timestamp 201505261000
            :date "26/05/2015"
            :month 05
            :day 26
            :time "10:00"
            :venue "JORWELL"}
           {:title "Software Risk Assessment"
            :timestamp 201505131000
            :date "13/05/2015"
            :month 05
            :day 13
            :time "10:00"
            :venue "LAW SUITE"}
           {:title "Computer Graphics"
            :timestamp 201505121430
            :date "12/05/2015"
            :month 05
            :day 12
            :time "14:30"
            :venue "JORWELL"}
           {:title "Computability"
            :timestamp 201505201430
            :date "20/05/2015"
            :month 05
            :day 20
            :time "10:00"
            :venue "JORWELL"}
           {:title "Distributed Systems"
            :timestamp 201505211430
            :date "21/05/2015"
            :month 05
            :day 21
            :time "14:30"
            :venue "SPORTS HALL"}
           {:title "C++ for Image Processing"
            :timestamp 201505281000
            :date "28/05/2015"
            :month 05
            :day 28
            :time "10:00"
            :venue "ARTS PAV"}
           {:title "Data Mining"
            :timestamp 201505011430
            :date "01/05/2015"
            :month 05
            :day 01
            :time "14:30"
            :venue "LAW SUITE"}
           {:title "Web Programming"
            :timestamp 201505041000
            :date "14/05/2015"
            :month 05
            :day 14
            :time "10:00"
            :venue "SPORTS HALL"}
           {:title "Algorithms and Complexity"
            :timestamp 201505191000
            :date "19/05/2015"
            :month 05
            :day 19
            :time "10:00"
            :venue "ARTS PAV"}
           ]
   :selected-exams ["Digital Media"]})
