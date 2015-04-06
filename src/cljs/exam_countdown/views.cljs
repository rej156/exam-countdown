(ns exam-countdown.views
  (:require [re-frame.core :refer [subscribe dispatch]]
            [exam-countdown.views.nav :refer [nav]]
            [exam-countdown.views.next-up :refer [next-up]]))

(defn main-panel    ;; the top level of our app
  []
  (let [name  (subscribe [:name])]   ;; obtain a reactive data source
    (fn []
      [:div
       [nav]
       [next-up]
       [:div.container
        [:h1 "Hello " @name]]])))

(defn exam-countdown-app
  []
  (let [ready?  (subscribe [:initialised?])]
    (fn []
      (if-not @ready?                ;; data is loaded?
         [:div "Initialising ..."]   ;; tell them we are working on it
         [main-panel]))))            ;; all good, render the app
