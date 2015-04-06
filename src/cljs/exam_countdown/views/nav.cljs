(ns exam-countdown.views.nav
  (:require [re-frame.core :refer [subscribe dispatch]]))

(defn jquery-dropdown-activate []
  (-> (js/$ ".dropdown-button")
                                     (.dropdown {:inDuration 300
                                                 :outDuration 255
                                                 :constrain_width false
                                                 :hover true
                                                 :gutter 0
                                                 :belowOrigin false})))

(defn nav []
  (fn []
    [:div.navbar
     [:nav
      [:a.dropdown-button.btn.left {:href "#"
                                    :on-click #(jquery-dropdown-activate)
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
