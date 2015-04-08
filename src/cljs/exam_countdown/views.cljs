(ns exam-countdown.views
  (:require [reagent.core :as reagent]
            [re-frame.core :refer [subscribe dispatch]]
            [exam-countdown.views.nav :refer [nav]]
            [exam-countdown.views.next-up :refer [next-up]]
            [cljs-time.core :refer [interval in-days date-time minutes from-now
  now time-now]]
            [exam-countdown.views.later-on :refer [later-on]]))

(defn main-panel    ;; the top level of our app
  []
  (let [name (subscribe [:name])]   ;; obtain a reactive data source
    (fn []
      [:div.content
       [nav]
       [next-up]
       [later-on]])))

(defn exam-countdown-app
  []
  (let [ready?  (subscribe [:initialised?])]
    (reagent/create-class
     {:component-did-mount #(.log js/console "rej156.github.io")
      :reagent-render (fn []
                        (if-not @ready?                ;; data is loaded?
                          [:div "Initialising ..."]   ;; tell them we are working on it
                          [main-panel]))})))            ;; all good, render the app
