(ns exam-countdown.views.next-up
  (:require [re-frame.core :refer [subscribe dispatch]]))

(defn nearest-exam-details []
  (let [nearest-exam (subscribe [:nearest-selected-exam])
        days-away (subscribe [:days-away @nearest-exam])]
    (fn []
      [:div.row.nearest-exam-details
       [:div.col.s6
        [:h5 "Next Up"
         [:h3 (:title @nearest-exam)]
         [:h4 (str "is in " @days-away " days")]]]
       [:div.col.s6
        [:h5 "Time"]
        [:h4 (:time @nearest-exam)]]
       [:div.col.s6
        [:h5 "Date"]
        [:h4 (:date @nearest-exam)]]
       [:div.col.s6
        [:h5 "Location"]
        [:h4 (:venue @nearest-exam)]]
       [:div.col.s6
        [:h5 "Open Maps"]
        [:h4
         ;; Nearest exam maps detail - Open latitude and longitude on click
         ]]])))

(defn next-up []
  (fn []
    [:div.next-up
     [:div.row.nearest-exam
      [nearest-exam-details]]
     ]))
