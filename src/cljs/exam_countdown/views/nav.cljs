(ns exam-countdown.views.nav
  (:require [re-frame.core :refer [subscribe dispatch]]))

(defn nav []
  (fn []
    [:div.navbar
     [:nav
      [:a.dropdown-button.btn.right {:href "#"
                                     :data-activates "dropdown1"
                                     :style {:height "100%"}}
      [:i.large.mdi-image-dehaze]]
      [:ul.dropdown-content {:id "dropdown1"}
       [:li
        [:a {:href "#"} "Exam options go here"]]
       [:li
        [:a {:href "#"} "Exam options 1"]]
       [:li
        [:a {:href "#"} "Exam options 2"]]]
      ]]))
