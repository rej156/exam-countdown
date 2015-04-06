(ns exam-countdown.views.next-up
  (:require [re-frame.core :refer [subscribe dispatch]]))

(defn next-up []
  (fn []
    [:div.next-up
     [:div.row.nearest-exam
      [:div.col.s6
       [:h5 "Next Up"
        [:h3
;;Subscribe [:nearest-exam] get name
         ]
        [:h4 (str "is in "
                  ;; nearest exam date - from now
                  ;; or replace with today if 0
                  " days")]]]]
     [:div.row.nearest-exam-details
      [:div.col.s6
       [:h5 "Time"]
       [:h4
        ;; Nearest exam time detail
        ]]
      [:div.col.s6
       [:h5 "Date"]
       [:h4
        ;; Nearest exam date detail
        ]]
      [:div.col.s6
       [:h5 "Location"]
       [:h4
        ;; Nearest exam location detail
        ]]
      [:div.col.s6
       [:h5 "Open Maps"]
       [:h4
        ;; Nearest exam maps detail - Open latitude and longitude on click
        ]]]
     ]))
