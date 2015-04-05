(ns exam-countdown.views
  (:require [re-frame.core :refer [subscribe dispatch]]))

(defn main-panel    ;; the top level of our app
  []
  (let [name  (subscribe [:name])]   ;; obtain a reactive data source
    (fn []
      [:div
       [:h1 "Hello " @name]])))

(defn exam-countdown-app
  []
  (let [ready?  (subscribe [:initialised?])]
    (fn []
      (if-not @ready?                ;; data is loaded?
         [:div "Initialising ..."]   ;; tell them we are working on it
         [main-panel]))))            ;; all good, render the app
