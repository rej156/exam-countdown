(ns ^:figwheel-no-load exam-countdown.dev
  (:require [exam-countdown.core :as core]
            [figwheel.client :as figwheel :include-macros true]
            [weasel.repl :as weasel]
            [reagent.core :as r]))

(enable-console-print!)

(figwheel/watch-and-reload
  :websocket-url "ws://46.101.42.30:3449/figwheel-ws"
  :jsload-callback (fn [] (r/force-update-all)))

(weasel/connect "ws://46.101.42.30:9001" :verbose true)

(core/init!)
