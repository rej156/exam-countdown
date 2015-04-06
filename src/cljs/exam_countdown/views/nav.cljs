(ns exam-countdown.views.nav
  (:require [re-frame.core :refer [subscribe dispatch]]))

(defn jquery-dropdown-activate []
  (-> (js/$ ".button-collapse")
      (.sideNav)))

(defn nav []
  (fn []
    [:div.navbar
     [:nav
      [:a.button-collapse.show-on-large {:href "#"
                                         :on-click #(jquery-dropdown-activate)
                                         :data-activates "slide-out"
                                         :style {:height "100%"}}
       [:i.mdi-navigation-menu]]
      [:ul.side-nav {:id "slide-out"}
       [:li
        [:a {:href "#"} "Exam options go here"]]
       [:li
        [:a {:href "#"} "Exam options 1"]]
       [:li
        [:a {:href "#"} "Exam options 2"]]]
      ]]))
