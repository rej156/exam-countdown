(ns exam-countdown.handlers
  (:require [exam-countdown.db :refer [default-value valid-schema?]]
            [re-frame.core :refer [register-handler debug after path trim-v]]))


;; -- Middleware --------------------------------------------------------------
;; See:  https://github.com/Day8/re-frame/wiki/Debugging-Event-Handlers
;;
(def standard-middlewares
  [trim-v
   ;; (if goog.DEBUG log-ex)    ;; will be available in v0.3.0
   ])

;; -- Helpers -----------------------------------------------------------------


;; -- Handlers ----------------------------------------------------------------

(register-handler                 ;; disptached to on app startup
  :initialise-db                  ;; event id being handled
  (fn  [_ _]                      ;; the handler
    default-value))               ;; all hail the new state


(register-handler                 ;; handlers changes the footer filter
  :set-name                       ;; event-id
  [standard-middlewares (path :name)]
  (fn                             ;; handler
    [db [new-name]]               ;; because of trim-v, not [_ new-name]
    new-name))

(register-handler
 :select-exam
 [standard-middlewares (path :selected-exams)]
 (fn
   [db [selected-exam]]
   (if-not (some #(= selected-exam %) db)
     (conj db selected-exam)
     (remove #{selected-exam} db))))
