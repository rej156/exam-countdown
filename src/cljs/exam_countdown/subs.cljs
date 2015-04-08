(ns exam-countdown.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]
            [cljs-time.core :refer [interval in-days date-time minutes from-now
  now time-now]]))


;; -- Helpers -----------------------------------------------------------------


;; -- Subscription handlers and registration  ---------------------------------

(register-sub
  :initialised?     ;; usage (subscribe [:initialised?])
  (fn  [db]
    (reaction (not (empty? @db)))))  ;; do we have data?


(register-sub
  :name              ;; usage (subscribe [:name])
  (fn  [db]
    (reaction (:name @db))))

(register-sub
 :exam-selected?
 (fn [db exam]
   (try (reaction (some #(= (second exam) %) (:selected-exams @db)))
        (catch :default e))))

(register-sub
 :selected-exams
 (fn [db]
   (reaction
    (->> (filter (fn [exam] (some #(= (:title exam ) %) (:selected-exams @db)))
                (:exams @db))
        (sort-by :timestamp)))))

(register-sub
 :other-selected-exams
 (fn [db]
   (reaction
    (->> (filter (fn [exam] (some #(= (:title exam ) %) (:selected-exams @db)))
                (:exams @db))
         (sort-by :timestamp)
         (rest)))))

(register-sub
 :nearest-selected-exam
 (fn [db]
   (reaction
    (->> (filter (fn [exam] (some #(= (:title exam ) %) (:selected-exams @db)))
                (:exams @db))
         (sort-by :timestamp)
         (first)))))

(register-sub
 :days-away
 (fn [db exam]
   (reaction
    (let [id (second exam)
          year 2015
          month (:month id)
          day (:day id)]
      (-> (interval (time-now) (date-time 2015 month day))
          (in-days))))))
