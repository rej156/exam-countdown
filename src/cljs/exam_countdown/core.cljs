(ns exam-countdown.core
  (:require-macros [secretary.core :refer [defroute]])
  (:require [goog.events :as events]
            [reagent.core :as reagent :refer [atom]]
            [re-frame.core :refer [dispatch dispatch-sync]]
            [secretary.core :as secretary]
            [exam-countdown.handlers]          ;; appears unused, but you need it here, to force loading.
            [exam-countdown.subs]              ;; appears unused, but you need it here, to force loading.
            [exam-countdown.views])
  (:import [goog History]
           [goog.history EventType]))

;; -- Routing -----------------------------------------------------------------
;; See example routing in the todomvc sample:
;; https://github.com/Day8/re-frame/blob/develop/examples/todomvc/src/todomvc/core.cljs#L18-L25


(defn mount-root
  []
  (reagent/render [exam-countdown.views/exam-countdown-app] (.getElementById js/document "app")))

;; -- Initialize app ----------------------------------------------------------
;;
;; See these notes:
;; https://github.com/Day8/re-frame/wiki/Bootstrap-An-Application
;;
(defn init! []
  (dispatch-sync [:initialise-db])
  (mount-root))
