(ns exam-countdown.views.later-on
  (:require [re-frame.core :refer [subscribe dispatch]]))

(defn later-on []
  (let [x 1]
    (fn []
      [:div.later-on
       [:div.row.later-on-header
        [:div.col.s3
         [:h5 "Later on"]]]
       [:div.row.later-on-list
        ;;For each exam selected that isn't the nearest (rest)
        ;; Show details in list items for each.
        [:div.exam-item
         [:div.col.s3
          [:h5 "Tomorrow"]]
         [:div.col.s9
          [:h5 "Interaction Design"]]
         [:div.col.s3.offset-s3
          [:p "06/13/1994"]]
         [:div.col.s3
          [:p "13:30"]]
         [:div.col.s3
          [:p "FB 1.13"]]]
        [:div.exam-item
         [:div.col.s3
          [:h5 "In 13 days"]]
         [:div.col.s9
          [:h5 "C++ for Image Processing"]]
         [:div.col.s3.offset-s3
          [:p "06/13/1994"]]
         [:div.col.s3
          [:p "13:30"]]
         [:div.col.s3
          [:p "Great Hall"]]]
        ]
       ])))
