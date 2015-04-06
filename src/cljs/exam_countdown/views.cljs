(ns exam-countdown.views
  (:require [reagent.core :as reagent]
            [re-frame.core :refer [subscribe dispatch]]
            [exam-countdown.views.nav :refer [nav jquery-dropdown-activate]]
            [exam-countdown.views.next-up :refer [next-up]]
            [cljs-time.core :refer [interval in-days date-time minutes from-now
  now time-now]]
            [exam-countdown.views.later-on :refer [later-on]]))

(defn main-panel    ;; the top level of our app
  []
  (let [name  (subscribe [:name])]   ;; obtain a reactive data source
    (fn []
      [:div
       [nav]
       [next-up]
       [later-on]
       (.log js/console (-> (interval (time-now) (date-time 2015 04 28))
                            (in-days)))
       [:div.container
        [:h1 "Welcome " @name]]])))

(defn exam-countdown-app
  []
  (let [ready?  (subscribe [:initialised?])]
    (reagent/create-class
     {:component-did-mount #(jquery-dropdown-activate)

      :reagent-render (fn []
                        (if-not @ready?                ;; data is loaded?
                          [:div "Initialising ..."]   ;; tell them we are working on it
                          [main-panel]))})))            ;; all good, render the app
